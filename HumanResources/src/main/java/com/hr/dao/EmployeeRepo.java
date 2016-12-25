package com.hr.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.hr.model.Department;
import com.hr.model.Employees;

public interface EmployeeRepo extends CrudRepository<Employees, Long>{
	//get by last name
	List<Employees> getByLastName(String lastname);
	//get by department id
	List<Employees> getByDepartment(Department d);
	//get by manager id
	List<Employees> getByManager(Employees e);
}
