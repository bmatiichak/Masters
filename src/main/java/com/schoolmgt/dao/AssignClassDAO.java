package com.schoolmgt.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.schoolmgt.dto.AssignClassDTO;


public interface AssignClassDAO extends JpaRepository<AssignClassDTO, Long> {
	

	public AssignClassDTO findById(long id);
	public AssignClassDTO findClassIdByStudentId(long id);
	public AssignClassDTO findByClassIdAndStudentId(long classId, long studentId);


}
