package com.own.proj.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.AbstractController;

import com.own.proj.editor.EmployeeNameEditor;
import com.own.proj.modelClass.Employee;

@Controller //This annotation tells that it is a controller class - way 1
//@Configuration //To achieve the same in XML use the mvc:annotation-driven
//@EnableWebMvc
@RequestMapping("/greet")
public class HelloController /*extends AbstractController*/ /*- It tells that it is a controller class - way 2*/{
//When there are more than one request handler method in controller class, is called MultiAction controller	
	
//	@Override
//	protected ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
//		ModelAndView model = new ModelAndView("HelloPage");
//		model.addObject("welcomeMessage", "Welcome here");
//		return model;
//	}
	
	@Autowired
	private Employee emp;
	
	@RequestMapping("/welcome/{countryName}/{userName}") //This annotation matches the requested url pattern
	public ModelAndView welcome(@PathVariable("userName") String name, @PathVariable("countryName") String country) 
			throws Exception { //This is a request handler method as @RequestMapping is used to handle the request
		ModelAndView model = new ModelAndView("HelloPage");
		model.addObject("welcomeMessage", "Welcome here " + name + " from " +country);
		return model;
	}
	
	@RequestMapping("/hi/{countryName}/{userName}")
	public ModelAndView welcomeYou(@PathVariable Map<String, String> pathVars) throws Exception { //Use of PathVariables on a map when there are more than one PathVariables in url
		String name = pathVars.get("userName");
		String country = pathVars.get("countryName");
		ModelAndView model = new ModelAndView("HelloPage");
		model.addObject("welcomeMessage", "Welcome " + name + " you are from " + country );
		return model;
	}
	
	@RequestMapping(value="/admissionForm", method=RequestMethod.GET)
	public ModelAndView getAdmissionForm() throws Exception { 
		ModelAndView model = new ModelAndView("AdmissionForm");
		return model;
	}
	
//	@RequestMapping(value="/submitAdmissionForm", method=RequestMethod.POST)
//	public ModelAndView submitAdmissionForm(@RequestParam Map<String, String> pathVars) throws Exception { 
//		String name = pathVars.get("studentName");
//		String hobby = pathVars.get("studentHobby");
//		ModelAndView model = new ModelAndView("AdmissionSuccess");
//		model.addObject("msg", "Details submitted by you, name: " + name + " and hobby: " + hobby );
//		return model;
//	}
	
	@RequestMapping(value="/submitAdmissionForm", method=RequestMethod.POST)
	public ModelAndView submitAdmissionForm(@RequestParam(value="studentName") String name,
			@RequestParam(value="studentHobby", defaultValue="Mou") String hobby) throws Exception {
		ModelAndView model = new ModelAndView("AdmissionSuccess");
		model.addObject("msg", "Details submitted by you, name: " + name + " and hobby: " + hobby );
		return model;
	}
	
	@RequestMapping(value="/empAdmissionForm", method=RequestMethod.GET)
	public ModelAndView getEmpAdmissionForm() throws Exception { 
//		String message = "NullPointerException";
//		if(message.equalsIgnoreCase("NullPointerException")){
//			throw new NullPointerException("Null Pointer Exception");
//		}
//		if(message.equalsIgnoreCase("Exception")){
//			throw new Exception("Exception");
//		}
		ModelAndView model = new ModelAndView("EmpAdmissionForm");
		return model;
	}
	
//	@RequestMapping(value="/empSubmitAdmissionForm", method=RequestMethod.POST)
//	public ModelAndView submitEmpAdmissionForm(@RequestParam(value="empName") String name,
//			@RequestParam(value="empHobby") String hobby) throws Exception { //Use of PathVariables on a map when there are more than one PathVariables in url
//		emp.setEmpName(name);
//		emp.setEmpHobby(hobby);
//		ModelAndView model = new ModelAndView("empSubmissionForm");
//		model.addObject("employee", emp);
//		return model;
//	}
	
	//Alternative way of previous example with less code
	@RequestMapping(value="/empSubmitAdmissionForm", method=RequestMethod.POST)
	public ModelAndView submitEmpAdmissionForm(@Valid @ModelAttribute("employee1") Employee employee2, BindingResult result) 
			throws Exception {//@ModelAttribute extracts all request parameters and binds it on 
    //corresponding properties of Employee object - auto data binding feature and @valid says at the time of performing of data binding
	//please consider the form validation related annotation

		if(result.hasErrors()) {
			ModelAndView model = new ModelAndView("EmpAdmissionForm");
			return model;
		}
		ModelAndView model = new ModelAndView("empSubmissionForm");
		return model;
	}

	@ModelAttribute //At first spring calls this method with this annotation before calling any request handler method
	public void addCommonObjects(Model  model) throws Exception {
		model.addAttribute("headerMessage", "Welcome To ABC Company");
	}
	
	//There are propertyEditors available in spring mvc. Ex: customDateEditor, customNumberEditor, FileEditor. It is used to perform type conversion 
	//while spring mvc performs the task of data binding
	@InitBinder //@InitBinder plays the role to identify the methods which initialize the WebDataBinder.
	public void customInitBinder(WebDataBinder binder) //WebDataBinder binds request parameter to JavaBean objects. It provides methods to customize the data type
	{
		//binder.setAllowedFields(new String[] {"empName"});
		//binder.setDisallowedFields(new String[] {"mobileNo"});
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy**MM**dd");
		binder.registerCustomEditor(Date.class, "dateOfBirth", new CustomDateEditor(sdf, false));
		binder.registerCustomEditor(String.class, "empName", new EmployeeNameEditor());//it will perform data binding task of "empName" field only after consulting 
		//with EmployeeNameEditor class
	}
	
}
