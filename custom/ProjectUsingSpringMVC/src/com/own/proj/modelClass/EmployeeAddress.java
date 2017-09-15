package com.own.proj.modelClass;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL) //It will exclude the field which is having null value in json response
@JsonIgnoreProperties("pincode") // It will exclude this specified field from json response
@JsonPropertyOrder({"emp_city", "country", "pincode"}) //Json response will be displayed in this specified order 
public class EmployeeAddress {
	private String country;
	@JsonProperty("emp_city") // In json response, the field name will be "emp_city", not "city"
	private String city;
	private int pincode;
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
}
