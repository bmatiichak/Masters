package com.schoolmgt.form;

import javax.validation.constraints.NotEmpty;

import com.schoolmgt.dto.BaseDTO;
import com.schoolmgt.dto.ClassDTO;
import com.schoolmgt.dto.SubjectDTO;
import com.schoolmgt.utility.DataUtility;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubjectFrom extends BaseDTO {

	@NotEmpty(message = "Subject name is required")
	private String subjectName;

	@NotEmpty(message = "Description is required")
	private String description;
	
	@NotEmpty(message = "Class is required")
	private String classId;
	
	public SubjectDTO getDTO() {
		SubjectDTO bean=new SubjectDTO();
		bean.setId(id);
		bean.setSubjectName(subjectName);
		bean.setDescription(description);
		bean.setCalssId(DataUtility.getLong(classId));

		return bean;
	}

	public void populate(SubjectDTO bean) {
		id = bean.getId();
		subjectName=bean.getSubjectName();
		description = bean.getDescription();
		classId = DataUtility.getStringData(bean.getCalssId());

	}

}
