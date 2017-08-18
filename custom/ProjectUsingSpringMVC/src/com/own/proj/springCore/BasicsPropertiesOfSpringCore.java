package com.own.proj.springCore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BasicsPropertiesOfSpringCore {

	public static void main(String args[]){
		@SuppressWarnings("resource")
	//	ApplicationContext context = new ClassPathXmlApplicationContext("SpringConfig.xml");
		ApplicationContext context = new ClassPathXmlApplicationContext("file:src/com/own/proj/springCore/SpringConfig.xml");//The ApplicationContext is 
		//the central interface within a Spring application for providing configuration information to the application.
		Restaurant resObj = (Restaurant) context.getBean("restaurantBean");
		resObj.greetCustomer();
		resObj.displayName();
		resObj.setMessage("Message 1");
		resObj.displayMessage();
		
//		Restaurant resObj2 = (Restaurant) context.getBean("restaurantBean");
//		resObj2.setMessage("Message 2");
//		resObj2.displayMessage(); //It will display "Message 1" if no scope is defined i.e singleton which is default scope or scope="singleton"
		//if scope="prototype", null will be displayed
		
		resObj.greet();
		resObj.welcomeNote();
		resObj.displayMyMessage();
		((AbstractApplicationContext)context).registerShutdownHook(); //Spring destroys all beans in it when main() method ends
	}
}
