package com.hr.service;

import com.hr.dto.UserDTO;

public interface UserService {
	UserDTO getUser(String userName, String Password);
}
