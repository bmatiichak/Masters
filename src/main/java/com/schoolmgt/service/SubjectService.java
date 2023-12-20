package com.schoolmgt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.schoolmgt.dao.SubjectDAO;
import com.schoolmgt.dto.SubjectDTO;


@Service
public class SubjectService {
	
	@Autowired
	public SubjectDAO dao;
	
	
	
	public SubjectDTO Add(SubjectDTO dto) {
			return	dao.save(dto);
	}
	

	public SubjectDTO findSubjectById(long id) {
		return dao.findById(id);
	}
	

	
	public List<SubjectDTO> list(){
		List<SubjectDTO> dto = dao.findAll();
		return dto;
	}
	
	public SubjectDTO update(SubjectDTO dto){
		SubjectDTO bean = dao.saveAndFlush(dto);
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
