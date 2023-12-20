package com.schoolmgt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolmgt.dao.ClassDAO;

import com.schoolmgt.dto.ClassDTO;

import com.schoolmgt.exception.RecordNotFoundException;

@Service
public class ClassService {
	@Autowired
	public ClassDAO dao;
	
	
	
	public ClassDTO Add(ClassDTO dto) {
			return	dao.save(dto);
	}
	

	public ClassDTO findClassById(long id) {
		return dao.findById(id);
	}
	
	public ClassDTO findByClassName(String className) {
		return dao.findByClassName(className);
	}
	
	
	public List<ClassDTO> list(){
		List<ClassDTO> dto = dao.findAll();
		return dto;
	}
	
	public ClassDTO update(ClassDTO dto){
		ClassDTO bean = dao.saveAndFlush(dto);
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
