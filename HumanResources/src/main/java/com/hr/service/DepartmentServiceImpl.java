package com.hr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.hr.dao.DepartmentRepo;
import com.hr.dao.MiscDao;
import com.hr.dto.DepartmentDTO;
import com.hr.model.Department;

public class DepartmentServiceImpl implements DepartmentService {
	
	private MiscDao m;
	
	@Autowired
	private DepartmentRepo d;
	
	@Override
	public List<DepartmentDTO> getDepartments() {
		return m.getAllDepartments();
	}
	
	@Override
	public Department getOne(Long ID){
		return d.findOne(ID);
	}

}
