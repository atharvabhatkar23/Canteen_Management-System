package com.app.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.AdminDTO;
import com.app.entities.Admin;
import com.app.exceptions.ResourceNotFoundException;
import com.app.repository.AdminRepository;

@Service
@Transactional
public class AdminServiceImpl implements AdminService{
    @Autowired
    private AdminRepository adminRepo;

//    @Autowired
//    private StudentCourseRepository studentCourseRepository; // Inject StudentCourseRepository

    @Autowired
    private ModelMapper mapper;

    @Override
    public AdminDTO getAdminByEmail(String adminEmail) {
        Admin admin = adminRepo.findByEmail(adminEmail)
                .orElseThrow(()-> new ResourceNotFoundException("Invalid Email for ROLE_ADMIN"));
        return mapper.map(admin, AdminDTO.class);
    }

//    @Override
//    public int getTotalStudents() {
//        return studentCourseRepository.getTotalStudentsEnrolledInCourses(); // Use StudentCourseRepository method
//    }
}
