package com.schoolmgt.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="subject")
@Getter
@Setter
public class SubjectDTO extends BaseDTO {
	
	
	
	@Column(name = "subjectName", length = 755)
	private String subjectName;

	@Column(name = "description", length = 755)
	private String description;
	
	private long calssId;
	
	@Column(name = "className", length = 755)
	private String className;

	@Override
	public String toString() {
		return "SubjectDTO [subjectName=" + subjectName + ", description=" + description + ", calssId=" + calssId + "]";
	}
	
	
	
	

}
