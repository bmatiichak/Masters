package com.schoolmgt.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.schoolmgt.dto.FeeDTO;

public interface FeeDAO extends JpaRepository<FeeDTO, Long> {
	

	public FeeDTO findById(long id);
	public List<FeeDTO> findByStudentId(long id);

}

