package com.hr.service;

import com.hr.dto.UserDTO;

public interface UserService {
	UserDTO getUser(String username, String Password);
}
