package com.own.proj.editor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class HobbyValidator implements ConstraintValidator<IsValidHobby, String>{
	private String hobbyList;
	
	@Override
	public void initialize(IsValidHobby isValidHobby){
		this.hobbyList=isValidHobby.listOfHobbies();
	}
	
	@Override
	public boolean isValid(String hobby, ConstraintValidatorContext arg1) {
		if(hobby == null)
		return false;
		else if(hobby.matches(hobbyList)){
			return true;
		}
		else{
			return false;
		}
	}

}
