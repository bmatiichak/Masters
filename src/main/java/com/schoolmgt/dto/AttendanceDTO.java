package com.schoolmgt.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="attendance")
@Getter
@Setter
public class AttendanceDTO extends BaseDTO{

	@Column(name = "className", length = 755)
	private String className;
	
	private long classId;
	
	@Column(name = "studentName", length = 755)
	private String studentName;
	
	private long studentId;

	@Column(name = "status", length = 755)
	private String status;
	
	
	
}

