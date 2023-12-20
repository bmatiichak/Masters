package com.schoolmgt.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="assignclass")
@Getter
@Setter
public class AssignClassDTO extends BaseDTO {
	
	@Column(name = "className", length = 755)
	private String className;

	@Column(name = "studentName", length = 755)
	private String studentName;
	
	private long studentId;
	
	private long classId;

	@Override
	public String toString() {
		return "AssignClassDTO [className=" + className + ", studentName=" + studentName + ", studentId=" + studentId
				+ ", classId=" + classId + "]";
	}
	
	
	
	
	

}
