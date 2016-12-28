package com.hr.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hr.dto.*;

@Repository
public class MiscDao {
	
	private static final String GET_USERS = "SELECT USERNAME, PASSWORD FROM "
			+ "hr.HR_USERS WHERE USERNAME=? AND PASSWORD=?";
	
	private static final String GET_JOBS = "SELECT JOB_ID, JOB_TITLE, MIN_SALARY, MAX_SALARY "
			+ "FROM hr.JOBS";
	
	private static final String GET_DEPARTMENTS = "SELECT DEPARTMENT_ID, DEPARTMENT_NAME, LOCATION_ID, MANAGER_ID FROM hr.DEPARTMENTS";
	
	private static final String GET_JOB_BY_ID = "SELECT JOB_ID, JOB_TITLE, MIN_SALARY, MAX_SALARY FROM hr.JOBS where job_id = ?";
	
	@Autowired
	private JdbcTemplate jdbc;
	
	public UserDTO getUser(String userName, String password){
		List<UserDTO> a =jdbc.query(GET_USERS, new Object[] {userName, password}, new UserRowMapper());
		
		if(a.isEmpty()){
			return null;
		}
		
		return a.get(0);
	}
	
	public List<JobDTO> getAllJobs(){
		return jdbc.query(GET_JOBS, new JobRowMapper());
	}
	
	public List<DepartmentDTO> getAllDepartments(){
		return jdbc.query(GET_DEPARTMENTS, new DepartmentRowMapper());
	}
	
	public JobDTO getJobByID(String ID){
	List<JobDTO> a = jdbc.query(GET_JOB_BY_ID, new Object[] {ID}, new JobRowMapper());
		if(a.isEmpty()){
			return null;
		}
		return a.get(0);
	}
}
