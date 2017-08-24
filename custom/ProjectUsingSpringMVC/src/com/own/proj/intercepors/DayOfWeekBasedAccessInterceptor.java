package com.own.proj.intercepors;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class DayOfWeekBasedAccessInterceptor extends HandlerInterceptorAdapter{

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler ) throws IOException {
		Calendar cal = Calendar.getInstance();
		@SuppressWarnings("static-access")
		int dayOfWeek = cal.get(cal.DAY_OF_WEEK);
		if(dayOfWeek==1){
			response.getWriter().write("We are not open on sunday");
			return false;
		}
		return true;
	}
	
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView model) throws IOException {
		//This method would be called after spring mvc executes the request handler method for the request
	}
	
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) throws IOException {
		//This method would be called after response object is produces by the view for the request
	}
	
}
