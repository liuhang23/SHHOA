package com.smartlab.oa.test;

import javax.annotation.Resource;
import javax.management.loading.PrivateClassLoader;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class TestAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	@Resource
	private TestService testService;
	
	public String execute() {
		System.out.println("-->actionTest ");
		testService.saveTwoUsers();
		return "success";
	}
	
	
}
