package com.hr.web;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hr.dto.*;
import com.hr.model.Employees;
import com.hr.model.Job;
import com.hr.service.*;

public class Controller {
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private MiscService misc;
	@Autowired
	private DepartmentService deptServ;
	@Autowired
	private UserService userService;
	@Autowired
	private UserSessionBean currentUser;
	
	@RequestMapping("/login")
	String login(Model model){
		return "login";
	}
	
	@RequestMapping("/checklogin")
	String checkLogin(@ModelAttribute("user") UserDTO current, BindingResult b, Model model) throws ParseException{
		//try to return a user dto object from back end given the password and username
		UserDTO newDTO = userService.getUser(current.getUsername(), current.getPassword());
		if(newDTO != null){
			this.currentUser.setUsername(current.getUsername());
			this.currentUser.setPassword(current.getPassword());
		}
		else{
			return "login";
		}
		return "redirect: /table";
	}
	
	@RequestMapping("/")
	String index(Model model){
		return "redirect :/table";
	}
	
	@RequestMapping("/table")
	String read(Model model){
		return "datatable";
	}
	
	@RequestMapping("/create-new")
	String create(Model model){
		//add jobs, and departments
		List<JobDTO> j = misc.getJobs();
		List<DepartmentDTO> d = deptServ.getDepartments();
		model.addAttribute("jobs", j);
		model.addAttribute("departments", d);
		return "create-new";
	}
	
	//after user enters info about new employee, data transferred here to be created
	@RequestMapping("/create")
	//@ModelAttribute(employee) = th:object=*{employee}
	String createNew(Model model, @ModelAttribute("employee") EmployeeDTO employee, BindingResult b){
		Employees toSave = new Employees();
		Job j = new Job();
		JobDTO dto = misc.getJobDTOByID(employee.getJobID());
		
		j.setJobID(employee.getJobID());
		j.setJobTitle(employee.getJobTitle());
		j.setMaxSalary(dto.getMaxSalary());
		j.setMinSalary(dto.getMinSalary());
		
		toSave.setFirstName(employee.getFirstName());
		toSave.setLastName(employee.getLastName());
		toSave.setJob(j);
		toSave.setSalary(employee.getSalary());
		toSave.setDepartment(deptServ.getOne(employee.getDepartmentID()));
		toSave.setPhoneNumber(employee.getPhoneNumber());
		
		this.employeeService.saveOrUpdate(toSave);
		return "redirect:/table";
	}
	
	@RequestMapping("/update")
	String update(Model model, @ModelAttribute EmployeeDTO dto, BindingResult br){
		
		return "update";
	}
	@RequestMapping("/delete")
	String delete(@RequestParam("id") Long ID){
		this.employeeService.deleteEmployee(ID);
		return "redirect:/table";
	}
	
	@RequestMapping("/logout")
	String logout(){
		this.currentUser.setPassword(null);
		this.currentUser.setId(null);
		this.currentUser.setUsername(null);
		return "redirect:/login";
	}
	
}
