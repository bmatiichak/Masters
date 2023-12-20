package com.schoolmgt.form;

import javax.validation.constraints.NotEmpty;

import com.schoolmgt.dto.BaseDTO;
import com.schoolmgt.dto.ClassDTO;
import com.schoolmgt.dto.UserDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClassForm extends BaseDTO{
	
	
	@NotEmpty(message = "Class name is required")
	private String className;

	@NotEmpty(message = "Description is required")
	private String description;
	
	public ClassDTO getDTO() {
		ClassDTO bean=new ClassDTO();
		bean.setId(id);
		bean.setClassName(className);
		bean.setDescription(description);

		return bean;
	}

	public void populate(ClassDTO bean) {
		id = bean.getId();
		className=bean.getClassName();
		description = bean.getDescription();

	}

	
	

}
