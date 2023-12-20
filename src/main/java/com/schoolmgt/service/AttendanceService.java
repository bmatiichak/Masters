package com.schoolmgt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolmgt.dao.AttendanceDAO;
import com.schoolmgt.dto.AttendanceDTO;


@Service
public class AttendanceService {

	@Autowired
	public AttendanceDAO dao;
	
	public AttendanceDTO Add(AttendanceDTO dto) {
		return	dao.save(dto);
}


public AttendanceDTO findAttendanceById(long id) {
	return dao.findById(id);
}



public List<AttendanceDTO> list(){
	List<AttendanceDTO> dto = dao.findAll();
	return dto;
}

public AttendanceDTO update(AttendanceDTO dto){
	AttendanceDTO bean = dao.saveAndFlush(dto);
	return bean;
}

public void delete(long id) throws Exception {
	if(id>0)
	{
		dao.deleteById(id);
	}else {
		throw new Exception("Not a valid id");
	}
	
}
}
