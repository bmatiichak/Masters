package com.schoolmgt.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolmgt.dao.UserDAO;
import com.schoolmgt.dto.UserDTO;
import com.schoolmgt.exception.RecordNotFoundException;
import com.schoolmgt.utility.PasswordSecurity;

@Service
public class UserService {

	@Autowired
	public UserDAO dao;
	
	
	
	public UserDTO Add(UserDTO dto) {
	UserDTO user = null;
	user = dao.findByEmail(dto.getEmail());
	System.out.println("user by email........: "+user);
	if(user != null) {
		throw new RecordNotFoundException("Email is already exists..");
	}
	    System.out.println("dto Before Save: "+dto);
	    dto.setPassword(PasswordSecurity.hashPassword(dto.getPassword()));
	    user = dao.save(dto);
       return  user;
	}
	
	public UserDTO Login(String username, String password) {
		UserDTO user =	dao.findByEmailAndPassword(username,  PasswordSecurity.hashPassword(password));
		return user;
	}
	
	public UserDTO findUserById(long id) {
		return dao.findById(id);
	}
	
	public UserDTO findUserByEmail(String email) {
		return dao.findByEmail(email);
	}
	
	public List<UserDTO> list(){
		List<UserDTO> dto = dao.findAll();
		return dto;
	}
	
	public UserDTO update(UserDTO dto){
		dto.setPassword(PasswordSecurity.hashPassword(dto.getPassword()));
		UserDTO bean = dao.saveAndFlush(dto);
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
	
	
	public List<UserDTO> userListByRole(String userRole){
		List<UserDTO> list = dao.findByUserRole(userRole);
		
		return list;
	}
	
	public List<UserDTO> searchByFirstName(String firstName){
		List<UserDTO> list = dao.findByFirstName(firstName);
		
		return list;
	}
	
	public UserDTO securePass(UserDTO dto) {
		dto.setPassword(PasswordSecurity.hashPassword(dto.getPassword()));
		return dto;
	}
	
	
	
}
