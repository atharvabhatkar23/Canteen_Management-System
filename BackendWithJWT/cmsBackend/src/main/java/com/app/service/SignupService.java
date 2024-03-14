package com.app.service;

import com.app.dto.Signup;
import com.app.dto.StudentDTO;

public interface SignupService {
	StudentDTO registerNewUser(StudentDTO request);
	
	Signup registerNewAdmin(Signup request); 
}
