package com.schoolmgt.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="st_class")
@Getter
@Setter
public class ClassDTO extends BaseDTO{

	@Column(name = "className", length = 755)
	private String className;

	@Column(name = "description", length = 755)
	private String description;
	
}
