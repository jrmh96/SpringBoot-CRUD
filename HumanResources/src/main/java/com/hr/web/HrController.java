package com.hr.web;

import java.text.ParseException;
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
		//try to return a user dto object from back end given the password and username
		String u = current.getUsername();
		String p = current.getPassword();
		UserDTO newDTO = UserService.getUser(current.getUsername(), current.getPassword());
		if(newDTO != null){
			this.currentUser.setUsername(current.getUsername());
			this.currentUser.setPassword(current.getPassword());
		}
		else{
			return "login";
		}
		return "redirect:/table";
	}
	
	@ModelAttribute("user")
	 public UserDTO getUserDto() {
		 return new UserDTO();
	 }
	
	@RequestMapping("/")
	String index(Model model){
		return "redirect:/table";
	}
	
	@RequestMapping("/table")
	String read(Model model){
		return "table";
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
