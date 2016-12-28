package com.hr.web;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;

import com.hr.dto.DepartmentDTO;
import com.hr.dto.EmployeeDTO;
import com.hr.dto.JobDTO;
import com.hr.dto.UserDTO;
import com.hr.dto.UserSessionBean;
import com.hr.model.Employees;
import com.hr.model.Job;
import com.hr.service.DepartmentService;
import com.hr.service.EmployeeService;
import com.hr.service.MiscService;
import com.hr.service.UserService;

//must finish adding gson data 
//to render the table

import com.google.common.collect.Lists;
import com.google.gson.Gson;

@Controller
public class HrController {
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private MiscService misc;
	@Autowired
	private DepartmentService deptServ;
	@Autowired
	private UserService UserService;
	@Autowired
	private UserSessionBean currentUser;
	
	@RequestMapping(value="/login")
	String login(Model model){
		return "login";
	}
	
	@RequestMapping("/checklogin")
	String checkLogin(@ModelAttribute("user") UserDTO current, BindingResult b, Model model) throws ParseException{
		//try to return a user dto object given the password and username
		UserDTO newDTO = UserService.getUser(current.getUsername(), current.getPassword());
		if(newDTO != null){
			this.currentUser.setUsername(current.getUsername());
			this.currentUser.setPassword(current.getPassword());
			return "redirect:/datatable-test"; //table
		}
		
		else{
			return "login";
		}
		
	}
	
	@ModelAttribute("user")
	 public UserDTO getUserDto() {
		 return new UserDTO();
	 }
	
	@RequestMapping("/")
	String index(Model model){
		return "redirect:/datatable-test";
	}
	
	@RequestMapping("/datatable-test")
	String read(Model model){
		return "datatable-test";
	}
	
	@RequestMapping("/getAll")
	@ResponseBody
	public String getAllEmployees(){
		List<EmployeeDTO> list = Lists.newArrayList();
		for(Employees e : employeeService.getAll()){
			EmployeeDTO edto = new EmployeeDTO();
			if(e.getDepartment()!=null){
				edto.setDepartmentID(e.getDepartment().getDepartmentId());
			}
			else{
				edto.setDepartmentID((long)000);
			}
				edto.setFirstName(e.getFirstName());
				edto.setLastName(e.getLastName());
				edto.setJobTitle(e.getJob().getJobTitle());
				edto.setID(e.getEmployeeId());
				edto.setDeleteLink("<a href='/delete?id=" + edto.getID()+ "' " 
				+"class='btn btn-danger'>Delete</a>");
				edto.setUpdateLink("<a href='/update?id=" + edto.getID()+ "' "
						+ "class='btn btn-success'>Update</a>");
				list.add(edto);
		}
		
		String jsonString = new Gson().toJson(list);
		return jsonString;
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
	
	@ModelAttribute("employee")
	public EmployeeDTO initEmployee(){
		return new EmployeeDTO();
	}
	//after user enters info about new employee, data transferred here to be created
	//@ModelAttribute(employee) = th:object=${employee}
	@RequestMapping("/create")
	String createNew(@ModelAttribute("employee") EmployeeDTO employee, BindingResult bindingResult, Model model) throws ParseException{
		
		Employees toSave = new Employees();
		Job j = new Job();
		JobDTO dto = misc.getJobDTOByID(employee.getJobID());
		
		j.setJobID(employee.getJobID());
		j.setJobTitle(employee.getJobTitle());
		j.setMaxSalary(dto.getMaxSalary());
		j.setMinSalary(dto.getMinSalary());
		
		toSave.setEmail("PIKACHU");
		toSave.setHireDate(new Date());
		toSave.setFirstName(employee.getFirstName());
		toSave.setLastName(employee.getLastName());
		toSave.setJob(j);
		toSave.setSalary(employee.getSalary());
		toSave.setDepartment(deptServ.getOne(employee.getDepartmentID()));
		toSave.setPhoneNumber(employee.getPhoneNumber());
		
		this.employeeService.saveOrUpdate(toSave);
		return "redirect:/datatable-test";
	}
	
	@RequestMapping("/update")
	String update(@RequestParam("id") Long empId, Model model) throws ParseException{
		Employees current = this.employeeService.getbyID(empId);
		EmployeeDTO emp = new EmployeeDTO();
		//populate fields
		emp.setID(current.getEmployeeId());
		emp.setFirstName(current.getFirstName());
		emp.setLastName(current.getLastName());
		emp.setPhoneNumber(current.getPhoneNumber());
		emp.setSalary(current.getSalary());
		emp.setDepartmentID(current.getDepartment().getDepartmentId());
		emp.setHireDate(current.getHireDate());
		emp.setJobTitle(current.getJob().getJobTitle());
		emp.setJobID(current.getJob().getJobID());
		emp.setEmail(current.getEmail());
		
		List<JobDTO> j = misc.getJobs();
		List<DepartmentDTO> d = deptServ.getDepartments();
		model.addAttribute("jobs", j);
		model.addAttribute("departments", d);
		model.addAttribute("employee", emp);
		return "update";
	}
	
	@ModelAttribute("employee")
	public EmployeeDTO getEmpDto(){
		return new EmployeeDTO();
	}
	
	@RequestMapping("/update-save")
	String updateSave(@ModelAttribute("employee") EmployeeDTO dto, BindingResult b, Model model) throws ParseException{
		createAndSave(dto);
		return "datatable-test";
	}
	
	private void createAndSave(EmployeeDTO emp) throws ParseException{
		//any fields that weren't changed will be same as the one in storage
		Employees toSave=this.employeeService.getbyID(emp.getID());
		//create job from job dto
		Job j = new Job();
		JobDTO setFrom = this.misc.getJobDTOByID(emp.getJobID());
		j.setJobID(setFrom.getJobID());
		j.setJobTitle(setFrom.getJobTitle());
		j.setMaxSalary(setFrom.getMaxSalary());
		j.setMinSalary(setFrom.getMinSalary());
		
		//create the new employee
		toSave.setFirstName(emp.getFirstName());
		toSave.setLastName(emp.getLastName());
		toSave.setPhoneNumber(emp.getPhoneNumber());
		toSave.setJob(j);
		toSave.setDepartment(this.deptServ.getOne(emp.getDepartmentID()));
		toSave.setSalary(emp.getSalary());
		this.employeeService.saveOrUpdate(toSave);
	}
	
	@RequestMapping("/delete")
	String delete(@RequestParam("id") Long ID){
		this.employeeService.deleteEmployee(ID);
		return "redirect:/datatable-test";
	}
	
	@RequestMapping("/logout")
	String logout(){
		this.currentUser.setPassword(null);
		this.currentUser.setId(null);
		this.currentUser.setUsername(null);
		return "redirect:/login";
	}
}
