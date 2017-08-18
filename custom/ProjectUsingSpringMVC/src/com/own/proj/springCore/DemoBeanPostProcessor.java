package com.own.proj.springCore;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

public class DemoBeanPostProcessor implements BeanPostProcessor, Ordered{

	@Override
	public Object postProcessAfterInitialization(Object arg0, String arg1) throws BeansException {
		System.out.println("DemoBeanPostProcessor processing bean instance after the init life cycle event of " +arg1);
		return arg0;
	}

	@Override
	public Object postProcessBeforeInitialization(Object arg0, String arg1) throws BeansException {
		System.out.println("DemoBeanPostProcessor processing bean instance after spring instantiates bean and just before init life cycle event of " +arg1);
		return arg0;
	}

	@Override
	public int getOrder() {
		// TODO Auto-generated method stub
		return 1;
	}

}
