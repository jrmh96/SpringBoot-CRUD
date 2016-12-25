package com.hr.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.hr.dto.UserDTO;

public class UserRowMapper implements RowMapper<UserDTO>{

	@Override
	public UserDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserDTO user = new UserDTO();
		user.setUsername(rs.getString("USERNAME"));
		user.setPassword(rs.getString("PASSWORD"));
		return null;
	}
	
}