package com.simplebootapp.services;

import com.simplebootapp.Entity.LoginModel;

public interface UserService {
	
	public boolean authenticateUser(LoginModel login);

}
