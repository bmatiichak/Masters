package com.schoolmgt.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.schoolmgt.dto.SubjectDTO;

public interface SubjectDAO extends JpaRepository<SubjectDTO, Long> {
	
	public SubjectDTO findById(long id);
	public List<SubjectDTO> findByCalssId(long id);

}

