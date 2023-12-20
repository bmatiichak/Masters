package com.schoolmgt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolmgt.dao.AssignClassDAO;
import com.schoolmgt.dao.ClassDAO;
import com.schoolmgt.dao.UserDAO;
import com.schoolmgt.dto.AssignClassDTO;
import com.schoolmgt.dto.ClassDTO;

@Service
public class AssignClassService {

	@Autowired
	public ClassDAO classdao;

	@Autowired
	public UserDAO userdao;
	
	@Autowired
	public AssignClassDAO dao;

	public AssignClassDTO Add(AssignClassDTO dto) {
		return dao.save(dto);
	}

	public AssignClassDTO findClassById(long id) {
		return dao.findById(id);
	}

	public List<AssignClassDTO> list() {
		List<AssignClassDTO> dto = dao.findAll();
		return dto;
	}

	public AssignClassDTO update(AssignClassDTO dto) {
		AssignClassDTO bean = dao.saveAndFlush(dto);
		return bean;
	}



	public void delete(long id) throws Exception {
		if (id > 0) {
			dao.deleteById(id);
		} else {
			throw new Exception("Something Went Wrong! Refresh the page and try again..");
		}

	}

}
