package com.own.proj.springCore;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class DemoBeanFactoryPostProcessor implements BeanFactoryPostProcessor{

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		BeanDefinition beanDef = beanFactory.getBeanDefinition("restaurantBean");
		MutablePropertyValues propertyValues = beanDef.getPropertyValues();
		propertyValues.addPropertyValue("welcomeNote1", "Welcome to the new second Restaurant");
	}

}
