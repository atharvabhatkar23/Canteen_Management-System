package com.app.service;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import com.app.entities.Role;

@Service
@Transactional
public class SigninServiceImpl implements SigninService {

	@Override
	public Role determineUserType(Authentication authentication) {

		// Get the authorities (roles) of the authenticated user
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

		// Check if the user has a specific role and determine the user type accordingly
		if (authorities != null && !authorities.isEmpty()) {
			for (GrantedAuthority authority : authorities) {
				String role = authority.getAuthority();
				System.out.println("in "+this.getClass());
				if (role.equals("ROLE_STUDENT")) {
					return Role.ROLE_STUDENT;
				} 
				 else if (role.equals("ROLE_ADMIN")) {
					return Role.ROLE_ADMIN;
				}
			}
		}

		// If no specific role is found, return a default user type
		return Role.ROLE_UNKNOWN;
	}

}
