package com.revision.beanvalidator.validator;

import java.util.Properties;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.revision.beanvalidator.beans.Teacher;

public class TeacherValidator implements Validator {
	private Resource resource;
	
	
	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		boolean b = Teacher.class.equals(clazz);
		return b;
	}

	@Override
	public void validate(Object target, Errors error) {
		try {
			Properties prop = PropertiesLoaderUtils.loadProperties(resource);
			Teacher tch = (Teacher) target;
			if(tch.getName().equals("") || tch.getName().equals(null)) {
				error.rejectValue("name", "key_name", prop.getProperty("error_name"));
			}
			if(tch.getQualification().equals("") || tch.getQualification().equals(null)) {
				error.rejectValue("qualification", "key_qualification", prop.getProperty("error_qualification"));
			}
			if(tch.getPhoneno().length() != 10) {
				error.rejectValue("phoneno", "key_phoneno", prop.getProperty("error_phone"));
			}
			if(tch.getStaffId() <=0) {
				error.rejectValue("staffId", "key_staffId", prop.getProperty("error_staffId"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
