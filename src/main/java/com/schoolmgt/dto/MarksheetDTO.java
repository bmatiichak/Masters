package com.schoolmgt.dto;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="marksheet")
@Getter
@Setter
public class MarksheetDTO extends BaseDTO{

	@Column(name = "studentName", length = 755)
	private String studentName;
	
	@Column(name = "studentId")
	private long studentId;

	@Column(name = "subject", length = 755)
	private String subject;
	

	@Column(name = "mark", length = 755)
	private String mark;
	
	@Transient
	private List<String> subjects;
	

	@Transient
	private List<String> marks;

}
