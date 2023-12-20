package com.schoolmgt.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.schoolmgt.dto.AttendanceDTO;


public interface AttendanceDAO extends JpaRepository<AttendanceDTO, Long> {
	

	public AttendanceDTO findById(long id);

}

