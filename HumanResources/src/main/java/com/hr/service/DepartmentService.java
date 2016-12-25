package com.hr.service;

import java.util.List;

import com.hr.dto.DepartmentDTO;
import com.hr.model.Department;

public interface DepartmentService {
	List<DepartmentDTO> getDepartments();
	Department getOne(Long ID);
}
