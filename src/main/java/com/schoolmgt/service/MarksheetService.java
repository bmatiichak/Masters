package com.schoolmgt.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolmgt.dao.MarksheetDAO;
import com.schoolmgt.dao.SubjectDAO;
import com.schoolmgt.dto.MarksheetDTO;
import com.schoolmgt.dto.SubjectDTO;
import com.schoolmgt.utility.DataUtility;

@Service
public class MarksheetService {

	@Autowired
	public MarksheetDAO dao;

	public MarksheetDTO Add(MarksheetDTO dto) {
		return dao.save(dto);
	}

	public MarksheetDTO findMarksheetById(long id) {
		return dao.findById(id);
	}

	public List<MarksheetDTO> list() {
		List<MarksheetDTO> dto = dao.findAll();
		return dto;
	}

	public MarksheetDTO update(MarksheetDTO dto) {
		MarksheetDTO bean = dao.saveAndFlush(dto);
		return bean;
	}

	public void delete(long id) throws Exception {
		if (id > 0) {
			dao.deleteById(id);
		} else {
			throw new Exception("Not a valid id");
		}

	}

	public long minMarks(long studentId) {

		List<MarksheetDTO> studentMarksheet = dao.findByStudentId(studentId);
		System.out.println("studentMarksheet: " + studentMarksheet.toString());
		List<Long> markList = new ArrayList<>();
		if (studentMarksheet.size() > 0) {

			for (MarksheetDTO marksheetDTO : studentMarksheet) {

				long mark = DataUtility.getLong(marksheetDTO.getMark());
				markList.add(mark);

			}

		}
		return Collections.min(markList);
	}

	public long maxMarks(long studentId) {

		List<MarksheetDTO> studentMarksheet = dao.findByStudentId(studentId);
		System.out.println("studentMarksheet: " + studentMarksheet.toString());
		List<Long> markList = new ArrayList<>();
		if (studentMarksheet.size() > 0) {

			for (MarksheetDTO marksheetDTO : studentMarksheet) {

				long mark = DataUtility.getLong(marksheetDTO.getMark());
				markList.add(mark);

			}

		}
		return Collections.max(markList);
	}

	public long avgMarks(long studentId) {

		List<MarksheetDTO> studentMarksheet = dao.findByStudentId(studentId);
		System.out.println("studentMarksheet: " + studentMarksheet.toString());
		List<Long> markList = new ArrayList<>();
		long i = 0, sum = 0, avg = 0;
		if (studentMarksheet.size() > 0) {

			for (MarksheetDTO marksheetDTO : studentMarksheet) {

				long mark = DataUtility.getLong(marksheetDTO.getMark());
				markList.add(mark);
				sum = sum + mark;
						i++;
			}
			try {
				avg = sum / i;
			}
catch (Exception e) {
	// TODO: handle exception
}
		}
		return avg;
	}

}
