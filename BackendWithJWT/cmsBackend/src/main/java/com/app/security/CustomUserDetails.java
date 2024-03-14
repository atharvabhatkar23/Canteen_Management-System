package com.app.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.app.entities.UserInfo;

public class CustomUserDetails implements UserDetails {
	private UserInfo user;

	public CustomUserDetails(UserInfo user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// class : SimpleGrantedAuthority --> GrantedAuthority
		return List.of(new SimpleGrantedAuthority(user.getRole().toString()));
	}

	@Override
	public String getPassword() {
		System.out.println("In get Password of CUstomerUSerDetails : "+user.getPassword());
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		System.out.println("in get username "+this.getClass());
		return user.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
