package com.schoolmgt.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.schoolmgt.dto.UserDTO;

public interface UserDAO extends JpaRepository<UserDTO, Long> {
	
	public UserDTO findByEmailAndPassword(String email, String password);
	public UserDTO findByEmail(String email);
	public List<UserDTO> findByUserRole(String userRole);
	public List<UserDTO> findByFirstName(String firstName);
	public UserDTO findById(long id);

}
