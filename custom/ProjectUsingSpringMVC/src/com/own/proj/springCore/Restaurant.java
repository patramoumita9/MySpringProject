package com.own.proj.springCore;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Restaurant /*implements InitializingBean, DisposableBean*/{
	//set the welcomeNote value from bean property using setter method provided here
	String welcomeNote;
	public void setWelcomeNote(String welcomeNote) {
		this.welcomeNote = welcomeNote;
	}
	public void greetCustomer() {
		//System.out.println("Welcome to the Restaurant");
		System.out.println(welcomeNote);
	}
	
	HotDrink hotDrink;
	//Dependency Injection by constructor
//	Restaurant(HotDrink hotDrink /*This is Tea object*/){
//		this .hotDrink=hotDrink;
//	}
	
	//Dependency Injection by setter method
	public void setHotDrink(HotDrink hotDrink /*This is Tea object*/){
		this .hotDrink=hotDrink;
	}
	
	public void prepareHotDrink() {
		hotDrink.prepareHotDrink();
	}
	
	List restaurantWaiterList;
	
	public void setRestaurantWaiterList(List restaurantWaiterList) {
		this.restaurantWaiterList = restaurantWaiterList;
	}
	
	public void displayName() {
		System.out.println("The name of the waiters are " +restaurantWaiterList);
	}
	
	//For bean scope
	String message;
	public void setMessage(String message) {
		this.message = message;
	}
	public void displayMessage() {
		System.out.println("The message is " +message);
	} 
	
	//For Bean life cycle
	public void greet() {
		System.out.println("Welcome!! This is life cycle demo");
	}
	
	//These two methods name will be same as provided in bean ex: init-method="init" destroy-method="destroy" - way 1
	//@PostConstruct //We can use this annotation to call this method, in that case we don't need to declare init-method="init" destroy-method="destroy" in configuration file - way 2
	public void init() {
		System.out.println("It will be called immediately after the bean initialization");
	}
	//@PreDestroy //description(same as PostConstruct)
	public void destroy() {
		System.out.println("It will be called just before the bean destruction");
	}
	
	//way 3 - implementing InitializingBean, DisposableBean
//	@Override
//	public void afterPropertiesSet() throws Exception {
//		System.out.println("RestaurantBean is going through afterPropertiesSet");
//		
//	}
//	@Override
//	public void destroy() throws Exception {
//		System.out.println("RestaurantBean is going to destroy now");
//	} 
	
	//Example of using BeanFactoryPostProcessor 
	String welcomeNote1;
	public void setWelcomeNote1(String welcomeNote1) {
		this.welcomeNote1 = welcomeNote1;
	}
	public void welcomeNote() {
		//System.out.println("Welcome to the Restaurant");
		System.out.println(welcomeNote1);
	}
	
	//Example of using PropertyPlaceholderConfigurer
	String myMessage;
	public void setMyMessage(String myMessage) {
		this.myMessage = myMessage;
	}
	public void displayMyMessage() {
		//System.out.println("Welcome to the Restaurant");
		System.out.println(myMessage);
	}
}
