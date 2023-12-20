package com.schoolmgt.ctl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.schoolmgt.dao.AssignClassDAO;
import com.schoolmgt.dao.MarksheetDAO;
import com.schoolmgt.dao.SubjectDAO;
import com.schoolmgt.dto.AssignClassDTO;
import com.schoolmgt.dto.ClassDTO;
import com.schoolmgt.dto.MarksheetDTO;
import com.schoolmgt.dto.SubjectDTO;
import com.schoolmgt.dto.UserDTO;
import com.schoolmgt.exception.RecordNotFoundException;
import com.schoolmgt.form.ClassForm;
import com.schoolmgt.form.MarksheetForm;
import com.schoolmgt.form.SubjectFrom;
import com.schoolmgt.service.AssignClassService;
import com.schoolmgt.service.ClassService;
import com.schoolmgt.service.MarksheetService;
import com.schoolmgt.service.SubjectService;
import com.schoolmgt.service.UserService;
import com.schoolmgt.utility.DataUtility;

@Controller
public class MarksheetCtl {

	@Autowired
	public UserService userService;

	@Autowired
	public ClassService classService;

	@Autowired
	public AssignClassService assignClassService;

	@Autowired
	public AssignClassDAO assignClassDAO;

	@Autowired
	public SubjectDAO subjectDAO;

	@Autowired
	public MarksheetDAO dao;

	@Autowired
	public MarksheetService service;

	@GetMapping("/marksheet")
	public String subject(@ModelAttribute("form") MarksheetForm form, Model model) {

		List<UserDTO> list = userService.userListByRole("Student");
		model.addAttribute("userList", list);
		return "marksheet";
	}

	@GetMapping("/marksheetList")
	public String MarksheetList(@ModelAttribute("form") MarksheetForm form, Model model) {

		List<UserDTO> list = userService.userListByRole("Student");
		model.addAttribute("userList", list);
		return "marksheetlist";
	}

	@PostMapping("/getMarksheetDetails")
	public String getMarksheet(@Valid @ModelAttribute("form") MarksheetForm form, BindingResult bindingResult,
			Model model) {
		long max=0, min =0, avg= 0, i = 0, sum = 0;
		System.out.println("form: " + form);
		try {
			if (bindingResult.hasErrors()) {
				System.out.println("bindingResult : " + bindingResult);
				return "marksheetlist";
			} else {
				MarksheetDTO bean = form.getDTO();

				long studentId = bean.getStudentId();
				List<MarksheetDTO> studentMarksheet = dao.findByStudentId(studentId);				
					System.out.println("studentMarksheet: "+studentMarksheet.toString());
				if(studentMarksheet.size()>0) {
					List<Long> markList = new ArrayList<>();
				for (MarksheetDTO marksheetDTO : studentMarksheet) {

					long mark = DataUtility.getLong(marksheetDTO.getMark());
					markList.add(mark);
					i++;
					sum = sum + mark;

				}
				max = Collections.max(markList);
				min = Collections.min(markList);
				avg = sum / i;
				}
				model.addAttribute("max", max);
				model.addAttribute("min", min);
				model.addAttribute("avg", avg);
				
				model.addAttribute("studentMarksheet", studentMarksheet);

				return "getmarksheet";
			}
		} catch (RecordNotFoundException e) {
			// TODO: handle exception
			model.addAttribute("error", e.getMessage());
			e.printStackTrace();
			return "marksheetlist";
		}
	}

	@PostMapping("/feathSubject")
	public String feathSubject(@Valid @ModelAttribute("form") MarksheetForm form, BindingResult bindingResult,
			Model model) {

		System.out.println("form: " + form);
		try {
			if (bindingResult.hasErrors()) {
				System.out.println("bindingResult : " + bindingResult);
				return "subjectmark";
			} else {
				MarksheetDTO bean = form.getDTO();

				AssignClassDTO assignClassDTO = assignClassDAO.findClassIdByStudentId(bean.getStudentId());
				if (assignClassDTO != null) {
					System.out.println("classId: " + assignClassDTO.getClassId());
					List<SubjectDTO> subjectDto = subjectDAO.findByCalssId(assignClassDTO.getClassId());
					ArrayList<String> subjectList = new ArrayList();

					for (SubjectDTO s : subjectDto) {
						subjectList.add(s.getSubjectName());
						System.out.println("s.getSubjectName(): " + s.getSubjectName());
					}
					model.addAttribute("subjectDto", subjectDto);
					model.addAttribute("studentId", bean.getStudentId());
					model.addAttribute("subjectList", subjectDto);
					return "subjectmark";
				} else {
					model.addAttribute("error", "First Assing a class to this student");
					return "subjectmark";
				}

			}
		} catch (RecordNotFoundException e) {
			// TODO: handle exception
			model.addAttribute("error", e.getMessage());
			e.printStackTrace();
			return "subjectmark";
		}
	}

	@PostMapping("/addMarksheet")
	public String Add(@Valid @ModelAttribute("form") MarksheetForm form, BindingResult bindingResult, Model model) {

		System.out.println("form: " + form);
		try {
			if (bindingResult.hasErrors()) {
				System.out.println("bindingResult : " + bindingResult);
				return "subjectmark";
			} else {

				UserDTO userDto = userService.findUserById(DataUtility.getLong(form.getStudentId()));
				String studentName = userDto.getFirstName() + " " + userDto.getLastName();

				MarksheetDTO dto = form.getDTO();

				MarksheetDTO dto2 = dao.findById(DataUtility.getLong(form.getStudentId()));
				if (dto2 == null) {
					List<String> subjectsList = form.getSubjectList();
					List<String> marksList = form.getMarks();

					for (int i = 0; i < subjectsList.size(); i++) {

						dto.setStudentId(DataUtility.getLong(form.getStudentId()));
						dto.setSubject(subjectsList.get(i));
						dto.setMark(marksList.get(i));
						dto.setStudentName(studentName);
						dao.save(dto);
						dto = new MarksheetDTO();
					}
					model.addAttribute("success", "Marks Added Sucessfully");

				} else {
					model.addAttribute("error", "Marks are already added for this students");
				}

				return "successmsg";
			}
		} catch (RecordNotFoundException e) {
			// TODO: handle exception
			model.addAttribute("error", e.getMessage());
			e.printStackTrace();
			return "subjectmark";
		}
	}

}
