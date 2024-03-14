package com.app.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.repository.AdminRepository;
//import com.app.repository.InstructorRepository;
import com.app.repository.StudentRepository;
import com.app.repository.UserRepository;
import com.app.dto.Signup;
import com.app.dto.StudentDTO;
import com.app.entities.Admin;
//import com.app.entities.Instructor;
import com.app.entities.Role;
import com.app.entities.Student;
import com.app.entities.UserInfo;

@Service
@Transactional
public class SignupServiceServiceImpl implements SignupService {

	@Autowired
	private UserRepository userRepo;

//	@Autowired
//	private InstructorRepository instRepo;
//
	@Autowired
	private StudentRepository studentRepo;
//
	@Autowired
	private AdminRepository adminRepo;

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private PasswordEncoder encoder;

	@Override
	public StudentDTO registerNewUser(StudentDTO request) {
//		if (request.getRole() == Role.ROLE_INSTRUCTOR) {
//			request.setPassword(encoder.encode(request.getPassword()));
//			Instructor persistentInstructor = instRepo.save(mapper.map(request, Instructor.class));
//			userRepo.save(new UserInfo(request.getEmail(), request.getPassword(), request.getRole().ROLE_INSTRUCTOR));
//			return mapper.map(persistentInstructor, Signup.class);
//		} else 
			if (request.getRole() == Role.ROLE_STUDENT) {
				request.setPassword(request.getName());
			System.out.println("before  student save " + request.getPassword()); 
			request.setPassword(encoder.encode(request.getName())); //encode the password 
			Student persistentStudent = studentRepo.save(mapper.map(request, Student.class));
			System.out.println("after student save " + request.getPassword());
			userRepo.save(new UserInfo(request.getEmail(), request.getPassword(), request.getRole().ROLE_STUDENT)); //user_info class for JWT
			return mapper.map(persistentStudent, StudentDTO.class);
			}
			
//		request.setPassword(encoder.encode(request.getPassword()));
//		//Admin admin = adminRepo.save(mapper.map(request, Admin.class));
//		userRepo.save(new UserInfo((long) 0,request.getEmail(), request.getPassword(), request.getRole().ROLE_ADMIN));
	//	return mapper.map(admin, Signup.class);
			return null;
			
	}

	@Override
	public Signup registerNewAdmin(Signup request) {
		// TODO Auto-generated method stub
		request.setPassword(encoder.encode(request.getPassword()));
		Admin admin = adminRepo.save(mapper.map(request, Admin.class));
		userRepo.save(new UserInfo(request.getEmail(), request.getPassword(), request.getRole().ROLE_ADMIN));
		return mapper.map(admin, Signup.class);
		
	}

}
