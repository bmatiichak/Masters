package com.schoolmgt.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.schoolmgt.dto.MarksheetDTO;

public interface MarksheetDAO extends JpaRepository<MarksheetDTO, Long> {
	

	public MarksheetDTO findById(long id);
	public List<MarksheetDTO> findByStudentId(long id);

}

