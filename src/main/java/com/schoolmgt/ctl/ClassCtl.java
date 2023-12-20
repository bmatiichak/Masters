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
import com.schoolmgt.dto.ClassDTO;
import com.schoolmgt.exception.RecordNotFoundException;
import com.schoolmgt.form.ClassForm;
import com.schoolmgt.service.ClassService;


@Controller
public class ClassCtl {
	
	@Autowired
	public ClassService service;

	
	@GetMapping("/class")
	public String RegistrationPage(@ModelAttribute("form")ClassForm form, Model model) {

		return "class";
	}
	
	@PostMapping("/addClass")
	public String Add(@Valid @ModelAttribute("form")ClassForm form,  BindingResult bindingResult, Model model) {

		System.out.println("form: "+form);
		try {
		if (bindingResult.hasErrors()) {
			System.out.println("bindingResult : "+bindingResult);
			return "class";
		}else {
			ClassDTO bean = form.getDTO();
			if(form.getId()>0) {
				
				service.update(bean);
				model.addAttribute("success", "Class Updated successfully");
			}else {
				ClassDTO dto = service.findByClassName(bean.getClassName());
				if(dto == null) {
					service.Add(bean);
					model.addAttribute("success", "Class Added successfully");
				}else {
					
					model.addAttribute("error", "Class is already added");
				}
				
			}
			
			return "class";
		}}catch (RecordNotFoundException e) {
			// TODO: handle exception
			model.addAttribute("error", e.getMessage());
			e.printStackTrace();
			return "class";
		}
	}
	
	@GetMapping("/classList")
	public String list(@ModelAttribute("form")ClassForm form, Model model){
	List<ClassDTO> list = service.list();
	model.addAttribute("list", list);
	return "classlist";
		
	}
	
	@GetMapping("/classEdit")	
	public String update(@ModelAttribute("form")ClassForm form, Model model, @RequestParam("id") long id ){
		ClassDTO bean = service.findClassById(id);
		form.populate(bean);
		model.addAttribute("bean",bean);	
		return "class";
	}
	
	@GetMapping("/classDelete")	
	public String delete(@ModelAttribute("form")ClassForm form, Model model, @RequestParam("id") long id ) throws Exception{
		service.delete(id);	
		
		List<ClassDTO> list =	service.list();
		model.addAttribute("list", list);
		model.addAttribute("success", "Class Deleted successfully");
		return "classlist";
	}
	

	

	
	
	
	
}
