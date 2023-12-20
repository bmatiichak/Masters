package com.schoolmgt.ctl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.schoolmgt.dto.FeeDTO;
import com.schoolmgt.dto.UserDTO;
import com.schoolmgt.exception.RecordNotFoundException;
import com.schoolmgt.form.FeeForm;
import com.schoolmgt.service.ClassService;
import com.schoolmgt.service.FeeService;
import com.schoolmgt.service.UserService;

@Controller
public class FeeCtl {
	
	@Autowired
	public FeeService service;
	
	@Autowired
	public UserService userService;
	
	@Autowired
	public ClassService classService;

	
	@GetMapping("/fee")
	public String fee(@ModelAttribute("form")FeeForm form, Model model) {

		List<UserDTO> userList =	userService.userListByRole("Student");	
		
		System.out.println(userList.toString());
		
		model.addAttribute("userList", userList);
		
		return "fee";
	}
	
	@PostMapping("/addFee")
	public String Add(@Valid @ModelAttribute("form")FeeForm form,  BindingResult bindingResult, Model model) {

		System.out.println("form: "+form);
		try {
		if (bindingResult.hasErrors()) {
			System.out.println("bindingResult : "+bindingResult);
			return "fee";
		}else {
			FeeDTO bean = form.getDTO();
			bean.setStudentName(userService.findUserById(bean.getStudentId()).getFirstName());
			if(form.getId()>0) {
				service.update(bean);
				model.addAttribute("success", "Fee Updated successfully");
			}else {
				
				service.Add(bean);
				model.addAttribute("success", "Fee Added successfully");
			}
			
			return "fee";
		}}catch (RecordNotFoundException e) {
			// TODO: handle exception
			model.addAttribute("error", e.getMessage());
			e.printStackTrace();
			return "fee";
		}
	}
	
	@GetMapping("/feeList")
	public String list(@ModelAttribute("form")FeeForm form, Model model, HttpSession session){
		UserDTO userSession = (UserDTO) session.getAttribute("user");
		List<FeeDTO> list = new ArrayList<>();
		if(userSession.getUserRole().equals("Student")) {
			list = service.list(userSession.getId());
		}else {
			list    = service.list();
		}
	model.addAttribute("list", list);
	return "feelist";
		
	}
	
	@GetMapping("/feeEdit")	
	public String update(@ModelAttribute("form")FeeForm form, Model model, @RequestParam("id") long id ){
	
		List<UserDTO> userList =	userService.userListByRole("Student");	
		
		System.out.println(userList.toString());
		
		model.addAttribute("userList", userList);

		
		FeeDTO bean = service.findFeeById(id);
		form.populate(bean);
		model.addAttribute("bean",bean);	
		return "fee";
	}
	
	@GetMapping("/feeDelete")	
	public String delete(@ModelAttribute("form")FeeForm form, Model model, @RequestParam("id") long id ) throws Exception{
		service.delete(id);	
		
		List<FeeDTO> list =	service.list();
		model.addAttribute("list", list);
		model.addAttribute("success", "Fee Deleted successfully");
		return "feelist";
	}

}
