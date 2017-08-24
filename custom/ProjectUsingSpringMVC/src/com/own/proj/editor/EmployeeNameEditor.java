package com.own.proj.editor;

import java.beans.PropertyEditorSupport;

public class EmployeeNameEditor extends PropertyEditorSupport{
	
	//Spring mvc runs this function before performing data binding task for empName property of Employee class
	public void setAsText(String empName) throws IllegalArgumentException{
		if(empName.contains("Mr.") || empName.contains("Ms.")) {
			setValue(empName);
		}
		else {
			empName = "Ms." + empName;
			setValue(empName);
		}
	}
}
