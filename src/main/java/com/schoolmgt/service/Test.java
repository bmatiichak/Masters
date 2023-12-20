package com.schoolmgt.service;

import org.springframework.beans.factory.annotation.Autowired;

public class Test {
	
	@Autowired
	public static UserService service;
	
	public static void main(String[] args) {
		System.out.println(service.userListByRole("Student"));;
	}

}
