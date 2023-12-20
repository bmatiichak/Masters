package com.schoolmgt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.schoolmgt.dao.FeeDAO;
import com.schoolmgt.dto.FeeDTO;

@Service
public class FeeService {

	@Autowired
	public FeeDAO dao;
	
	public FeeDTO Add(FeeDTO dto) {
		return	dao.save(dto);
}


public FeeDTO findFeeById(long id) {
	return dao.findById(id);
}



public List<FeeDTO> list(){
	List<FeeDTO> dto = dao.findAll();
	return dto;
}

public List<FeeDTO> list(long id){
	List<FeeDTO> dto = dao.findByStudentId(id);
	return dto;
}



public FeeDTO update(FeeDTO dto){
	FeeDTO bean = dao.saveAndFlush(dto);
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
