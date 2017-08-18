package com.own.proj.springCore;

public class Tea implements HotDrink {

	@Override
	public void prepareHotDrink() {
		System.out.println("Dear customer, Please wait while we are preparing hot drink for you");
	}

}
