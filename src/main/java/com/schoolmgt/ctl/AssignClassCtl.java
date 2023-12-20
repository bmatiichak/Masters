package com.schoolmgt.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.schoolmgt.dao.AssignClassDAO;
import com.schoolmgt.dto.AssignClassDTO;
import com.schoolmgt.dto.ClassDTO;
import com.schoolmgt.dto.UserDTO;
import com.schoolmgt.form.AssignClassForm;
import com.schoolmgt.service.AssignClassService;
import com.schoolmgt.service.ClassService;
import com.schoolmgt.service.UserService;
import com.schoolmgt.utility.DataUtility;

@Controller
public class AssignClassCtl {
	
	@Autowired
	public ClassService classService;
	
	@Autowired
	public UserService userService;
	
	@Autowired
	public AssignClassService service;
	
	@Autowired
	public AssignClassDAO dao;
	
	@GetMapping("/assignClass")
	public String assingClass(@ModelAttribute("form")AssignClassForm form, Model model) {
          
	List<ClassDTO> classList =	classService.list();
	List<UserDTO> userList =	userService.userListByRole("Student");	
	
	System.out.println(userList.toString());
	
	model.addAttribute("userList", userList);
	model.addAttribute("classList", classList);
	
		return "assingclass";
	}
	
	
	
	@PostMapping("/addAssignedClass")
	public String addAssignedClass(@ModelAttribute("form")AssignClassForm form, Model model ) {
          
	AssignClassDTO dto = form.getDTO();	
	
	UserDTO userDto = userService.findUserById(DataUtility.getLong(form.getStudentId()));
    dto.setStudentName(userDto.getFirstName()+ " "+ userDto.getLastName());
    
    ClassDTO classDto = classService.findClassById(DataUtility.getLong(form.getClassId()));
    dto.setClassName(classDto.getClassName());
    AssignClassDTO dto2 =    dao.findByClassIdAndStudentId(DataUtility.getLong(form.getClassId()), DataUtility.getLong(form.getStudentId()));
   
    if(dto2 == null) {
    	 service.Add(dto);	
    		model.addAttribute("success", dto.getStudentName()+ "is added into class" +dto.getClassName());
    }else {
    	model.addAttribute("error", "Already Assigned");
    }
    
   

	
		return "assingclass";
	}

}
