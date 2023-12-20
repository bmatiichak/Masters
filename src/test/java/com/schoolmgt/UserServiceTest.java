package com.schoolmgt;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import org.junit.jupiter.api.Test;

import com.schoolmgt.dto.UserDTO;
import com.schoolmgt.service.UserService;
import com.schoolmgt.utility.PasswordSecurity;

@SpringBootTest
public class UserServiceTest {
	
	@Autowired
	UserService userService;
	
	@Test
	public void testService() {
		Assert.notNull(userService);
	}
	
	@Test
	public void testUpdateSigner() {
		UserDTO userDto = new UserDTO();
		userDto.setPassword("qwerty123");
		String updatedPass = PasswordSecurity.hashPassword(userDto.getPassword());
		UserDTO updatedUser = userService.securePass(userDto);
		assertEquals(updatedUser.getPassword(), updatedPass);
		
	}
	
}