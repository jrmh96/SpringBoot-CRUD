package com.hr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hr.model.Department;
import com.hr.model.Employees;

import com.hr.dao.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepo empRepo;
	
	
	@Transactional(readOnly=true)
	public List<Employees> getAll() {
		return (List<Employees>) empRepo.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Employees getbyID(Long id) {
		return empRepo.findOne(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Employees> getByDepartment(Department d) {
		return empRepo.getByDepartment(d);
	}

	@Override
	@Transactional
	public void deleteEmployee(Employees emp) {
		empRepo.delete(emp);
	}

	@Override
	@Transactional
	public void deleteEmployee(Long ID) {
		//  Auto-generated method stub
		if(ID==null){
			System.out.println("ID is null");
			return;
		}
		empRepo.delete(ID);
	}

	@Override
	@Transactional
	public Employees saveOrUpdate(Employees e) {
		return empRepo.save(e);
	}
	
}