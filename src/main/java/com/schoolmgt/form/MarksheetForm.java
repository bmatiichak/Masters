package com.schoolmgt.form;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import com.schoolmgt.dto.BaseDTO;
import com.schoolmgt.dto.MarksheetDTO;
import com.schoolmgt.dto.SubjectDTO;
import com.schoolmgt.utility.DataUtility;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MarksheetForm extends BaseDTO{
	
	@NotEmpty(message = "Student name is required")
	private String studentId;
	
	private List<String> marks;
	
	private List<String> subjectList;
	
	
	public MarksheetDTO getDTO() {
		MarksheetDTO bean=new MarksheetDTO();
		bean.setId(id);
		bean.setStudentId(DataUtility.getLong(studentId));
        bean.setMarks(marks);
        bean.setSubjects(subjectList);
		return bean;
	}

	public void populate(MarksheetDTO bean) {
		id = bean.getId();
		studentId = DataUtility.getStringData(bean.getStudentId());
		marks = bean.getMarks();
		subjectList = bean.getSubjects();
	}

	@Override
	public String toString() {
		return "MarksheetForm [studentId=" + studentId + ", marks=" + marks + "]";
	}

	
	


}
