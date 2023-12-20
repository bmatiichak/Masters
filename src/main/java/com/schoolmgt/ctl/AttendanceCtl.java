package com.schoolmgt.ctl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.schoolmgt.dto.AttendanceDTO;
import com.schoolmgt.dto.ClassDTO;
import com.schoolmgt.dto.UserDTO;
import com.schoolmgt.exception.RecordNotFoundException;
import com.schoolmgt.form.AttendanceForm;
import com.schoolmgt.service.AttendanceService;
import com.schoolmgt.service.ClassService;
import com.schoolmgt.service.UserService;

@Controller
public class AttendanceCtl {

	@Autowired
	public AttendanceService service;
	
	@Autowired
	public UserService userService;
	
	@Autowired
	public ClassService classService;

	
	@GetMapping("/attendance")
	public String RegistrationPage(@ModelAttribute("form")AttendanceForm form, Model model) {

		List<ClassDTO> classList =	classService.list();
		List<UserDTO> userList =	userService.userListByRole("Student");	
		
		System.out.println(userList.toString());
		
		model.addAttribute("userList", userList);
		model.addAttribute("classList", classList);
		
		return "attendance";
	}
	
	@PostMapping("/addAttendance")
	public String Add(@Valid @ModelAttribute("form")AttendanceForm form,  BindingResult bindingResult, Model model) {

		System.out.println("form: "+form);
		try {
		if (bindingResult.hasErrors()) {
			System.out.println("bindingResult : "+bindingResult);
			return "attendance";
		}else {
			AttendanceDTO bean = form.getDTO();
			bean.setClassName(classService.findClassById(bean.getClassId()).getClassName());
			bean.setStudentName(userService.findUserById(bean.getStudentId()).getFirstName());
			if(form.getId()>0) {
				
				service.update(bean);
				model.addAttribute("success", "Attendance Updated successfully");
			}else {
				
				service.Add(bean);
				model.addAttribute("success", "Attendance Added successfully");
			}
			
			return "attendance";
		}}catch (RecordNotFoundException e) {
			// TODO: handle exception
			model.addAttribute("error", e.getMessage());
			e.printStackTrace();
			return "attendance";
		}
	}
	
	@GetMapping("/attendanceList")
	public String list(@ModelAttribute("form")AttendanceForm form, Model model){
	List<AttendanceDTO> list = service.list();
	model.addAttribute("list", list);
	return "attendancelist";
		
	}
	
	@GetMapping("/attendanceEdit")	
	public String update(@ModelAttribute("form")AttendanceForm form, Model model, @RequestParam("id") long id ){
	
		List<ClassDTO> classList =	classService.list();
		List<UserDTO> userList =	userService.userListByRole("Student");	
		
		System.out.println(userList.toString());
		
		model.addAttribute("userList", userList);
		model.addAttribute("classList", classList);
		
		AttendanceDTO bean = service.findAttendanceById(id);
		form.populate(bean);
		model.addAttribute("bean",bean);	
		return "attendance";
	}
	
	@GetMapping("/attendanceDelete")	
	public String delete(@ModelAttribute("form")AttendanceForm form, Model model, @RequestParam("id") long id ) throws Exception{
		service.delete(id);	
		
		List<AttendanceDTO> list =	service.list();
		model.addAttribute("list", list);
		model.addAttribute("success", "Attendance Deleted successfully");
		return "attendancelist";
	}
	
}
