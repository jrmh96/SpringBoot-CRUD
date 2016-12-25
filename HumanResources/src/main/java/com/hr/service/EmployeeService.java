package com.hr.service;

import java.util.List;
import com.hr.model.Employees;
import com.hr.model.Department;

public interface EmployeeService {
	List<Employees> getAll();
	Employees getbyID(Long id);
	List<Employees> getByDepartment(Department d);
	void deleteEmployee(Employees emp);
	void deleteEmployee(Long ID);
	Employees saveOrUpdate(Employees e);
}
