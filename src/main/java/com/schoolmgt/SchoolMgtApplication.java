package com.schoolmgt;



import org.apache.logging.log4j.LogManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SchoolMgtApplication {
	
	public static void main(String[] args) {
		final org.apache.logging.log4j.Logger LOGGER =  LogManager.getLogger(SchoolMgtApplication.class);
		SpringApplication.run(SchoolMgtApplication.class, args);

		//System.out.println(userDao.findByUserRole("Student").toString());
		LOGGER.info("Info log message");
        LOGGER.debug("Debug log message");
        LOGGER.error("Error log message");
		
	}

}
