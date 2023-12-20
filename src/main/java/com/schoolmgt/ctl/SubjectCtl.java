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
import com.schoolmgt.dto.SubjectDTO;
import com.schoolmgt.exception.RecordNotFoundException;
import com.schoolmgt.form.SubjectFrom;
import com.schoolmgt.service.ClassService;
import com.schoolmgt.service.SubjectService;

@Controller
public class SubjectCtl {

	@Autowired
	public SubjectService service;
	
	@Autowired
	public ClassService classService;

	
	@GetMapping("/subject")
	public String subject(@ModelAttribute("form")SubjectFrom form, Model model) {
       
		List<ClassDTO> list = classService.list();
		System.out.println(list.toString());
		model.addAttribute("list", list);
		return "subject";
	}
	
	@PostMapping("/addSubject")
	public String Add(@Valid @ModelAttribute("form")SubjectFrom form,  BindingResult bindingResult, Model model) {

		System.out.println("form: "+form);
		try {
		if (bindingResult.hasErrors()) {
			System.out.println("bindingResult : "+bindingResult);
			return "subject";
		}else {
			SubjectDTO bean = form.getDTO();
			
			bean.setClassName(classService.findClassById(bean.getCalssId()).getClassName());
			
			if(form.getId()>0) {
				
				service.update(bean);
				model.addAttribute("success", "Subject Updated successfully");
			}else {
				
				service.Add(bean);
				model.addAttribute("success", "Subject Added successfully");
			}
			
			return "subject";
		}}catch (RecordNotFoundException e) {
			// TODO: handle exception
			model.addAttribute("error", e.getMessage());
			e.printStackTrace();
			return "subject";
		}
	}
	
	@GetMapping("/subjectList")
	public String list(@ModelAttribute("form")SubjectFrom form, Model model){
	
	List<SubjectDTO> list = service.list();
	
	model.addAttribute("list", list);
	return "subjectlist";
		
	}
	
	@GetMapping("/subjectEdit")	
	public String update(@ModelAttribute("form")SubjectFrom form, Model model, @RequestParam("id") long id ){
		SubjectDTO bean = service.findSubjectById(id);

		form.populate(bean);
		List<ClassDTO> list = classService.list();
		model.addAttribute("list", list);
		model.addAttribute("bean",bean);	
		return "subject";
	}
	
	@GetMapping("/subjectDelete")	
	public String delete(@ModelAttribute("form")SubjectFrom form, Model model, @RequestParam("id") long id ) throws Exception{
		service.delete(id);	
		
		List<SubjectDTO> list =	service.list();
		model.addAttribute("list", list);
		model.addAttribute("success", "Class Deleted successfully");
		return "subjectlist";
	}
	
}
