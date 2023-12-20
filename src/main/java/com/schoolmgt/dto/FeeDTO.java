package com.schoolmgt.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="fee")
@Getter
@Setter
public class FeeDTO extends BaseDTO{

	@Column(name = "studentName", length = 755)
	private String studentName;
	
	@Column(name = "studentId")
	private long studentId;
	
	@Column(name = "amount")
	private long amount;
	
	
	
	

	
	
}
