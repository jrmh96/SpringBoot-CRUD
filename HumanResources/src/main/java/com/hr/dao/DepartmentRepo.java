package com.hr.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.hr.model.Department;
import com.hr.model.Employees;

public interface DepartmentRepo extends CrudRepository<Department, Long>{
	//get by managerID
	List<Department> getByManager(Employees e);
	
}