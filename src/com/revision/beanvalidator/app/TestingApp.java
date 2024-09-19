package com.revision.beanvalidator.app;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.validation.MapBindingResult;
import org.springframework.validation.ObjectError;

import com.revision.beanvalidator.beans.Teacher;
import com.revision.beanvalidator.validator.TeacherValidator;

public class TestingApp {
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/"
				+ "revision/beanvalidator/resources/applicationContext.xml");
		Teacher teach = context.getBean("teachObj", Teacher.class);
		Map<String, Object> map = new HashMap<String , Object>();
		MapBindingResult mbr = new MapBindingResult(map, "mymapObj");
		TeacherValidator tchvalidator = (TeacherValidator)context.getBean("tchValObj");
		tchvalidator.validate(teach, mbr);
		List<ObjectError> list =  mbr.getAllErrors();
		if(list.isEmpty()) {
			System.out.println(teach);
		}else {
			for(ObjectError oe :list) {
				System.err.println(oe.getDefaultMessage());
			}
		}
		
	}
}
