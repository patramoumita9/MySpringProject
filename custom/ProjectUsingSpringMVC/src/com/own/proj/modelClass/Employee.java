package com.own.proj.modelClass;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.own.proj.editor.IsValidHobby;

public class Employee {
	
	@Pattern(regexp="[^0-9]*")//It is used to perform the validation task of this field
	private String empName;
	
	@Size(min=3, max=30/*, message = "Hobby must be between {min} and {max} characters long"*/ /*way 1 for custom error msg*/)
	@IsValidHobby/*(listOfHobbies = "Music|Cricket|Hockey|Football")*/ //to make it optional default value needs to be provided in IsValidHobby class
	private String empHobby;
	
	@Past //It checks whether the date is past, if the date is future date, it will give a binding error at the time of data 
	//binding. Few more annotations @Future, @Min, @NotNull, @NotEmpty
	private Date dateOfBirth;
	
	@Max(2222)//The length of this field will be less than or equal to 2222
	private long mobileNo;
	private List<String> empSkills;
	private EmployeeAddress empAddress;
	
	public EmployeeAddress getEmpAddress() {
		return empAddress;
	}
	public void setEmpAddress(EmployeeAddress empAddress) {
		this.empAddress = empAddress;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public List<String> getEmpSkills() {
		return empSkills;
	}
	public void setEmpSkills(List<String> empSkills) {
		this.empSkills = empSkills;
	}
	public String getEmpName() {
		return empName;
	}
	public String getEmpHobby() {
		return empHobby;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public void setEmpHobby(String empHobby) {
		this.empHobby = empHobby;
	}
}
