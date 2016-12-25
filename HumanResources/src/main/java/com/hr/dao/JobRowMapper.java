package com.hr.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.hr.dto.JobDTO;

public class JobRowMapper implements RowMapper<JobDTO>{

	@Override
	public JobDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		JobDTO job = new JobDTO();
		job.setJobID(rs.getString("JOB_ID"));
		job.setJobTitle(rs.getString("JOB_TITLE"));
		job.setMaxSalary(rs.getBigDecimal("MAX_SALARY"));
		job.setMinSalary(rs.getBigDecimal("MIN_SALARY"));
		return job;
	}
	
}
