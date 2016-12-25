package com.hr.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.hr.dto.DepartmentDTO;

public class DepartmentRowMapper implements RowMapper<DepartmentDTO>{
	
	@Override
	public DepartmentDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		DepartmentDTO dep = new DepartmentDTO();
		dep.setDepartmentID(rs.getLong("DEPARTMENT_ID"));
		dep.setDeptName(rs.getString("DEPARTMENT_NAME"));
		dep.setLocationID(rs.getLong("LOCATION_ID"));
		dep.setManagerID(rs.getLong("MANAGER_ID"));
		return dep;
	}
	
}