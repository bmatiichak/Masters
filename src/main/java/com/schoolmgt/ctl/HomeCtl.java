package com.schoolmgt.ctl;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.schoolmgt.dao.UserDAO;

@Controller
public class HomeCtl {
	
	@Autowired
	private UserDAO dao;
	
	@GetMapping("/")
	public String homePage() {
		System.out.println(dao.findByUserRole("Admin").toString());
		return "home";
	}
	
	@GetMapping("/home")
	public String home() {
		return "home";
	}

	

}
