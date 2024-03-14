package com.app.service;

import org.springframework.security.core.Authentication;

import com.app.entities.Role;

public interface SigninService {
	public Role determineUserType(Authentication authentication);
}
