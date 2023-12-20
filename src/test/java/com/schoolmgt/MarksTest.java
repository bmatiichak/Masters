package com.schoolmgt;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.schoolmgt.ctl.HomeCtl;
import com.schoolmgt.service.MarksheetService;

@SpringBootTest
public class MarksTest {

	@Autowired
	public HomeCtl homeCtl;

	@Autowired
	public MarksheetService mService;

	@Test
	void contextLoads() {

		assertNotNull(homeCtl);
	}

	@Test
	void test() {

		assertNotNull(mService);
	}

	@Test
	void Verfiymin() {

		long minMark = mService.minMarks(2);

		assertEquals(minMark, 66);
	}
	
	@Test
	void VerfiyMax() {

		long mark = mService.maxMarks(2);

		assertEquals(mark, 80);
	}
	
	@Test
	void VerfiyAvg() {

		long mark = mService.avgMarks(10);
        System.out.println("mark: "+mark);
		assertEquals(mark, 64);
	}

}
