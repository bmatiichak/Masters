package com.schoolmgt.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.schoolmgt.dto.ClassDTO;


public interface ClassDAO extends JpaRepository<ClassDTO, Long> {
	

	public ClassDTO findById(long id);
	public ClassDTO findByClassName(String className);

}
