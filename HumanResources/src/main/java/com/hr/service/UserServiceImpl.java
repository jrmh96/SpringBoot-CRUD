package com.hr.service;

import org.springframework.transaction.annotation.Transactional;

import com.hr.dao.MiscDao;
import com.hr.dto.UserDTO;

public class UserServiceImpl implements UserService{
	// MiscellaneousDao
	private MiscDao m;
	
	@Override
	@Transactional(readOnly=true)
	public UserDTO getUser(String userName, String password) {
		return m.getUser(userName, password);
	}
	
}
