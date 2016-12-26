package com.hr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hr.dao.MiscDao;
import com.hr.dto.UserDTO;


@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private MiscDao m;
	
	@Override
	@Transactional(readOnly=true)
	public UserDTO getUser(String userName, String password) {

		UserDTO p= m.getUser(userName, password);
		return p;
	}
	
}
