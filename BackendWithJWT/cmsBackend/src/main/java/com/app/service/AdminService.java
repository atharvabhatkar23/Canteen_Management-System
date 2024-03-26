// StudentService.java
package com.app.service;

import java.time.LocalDate;
import java.util.List;

import com.app.dto.AdminDTO;
import com.app.dto.ApiResponse;
import com.app.dto.GetAllStudentDTO;
import com.app.dto.ItemMasterDTO;
import com.app.dto.SignInDTO;
import com.app.dto.StudentDTO;
import com.app.dto.UpdatePasswordDTO;
import com.app.entities.Student;

public interface AdminService {

	AdminDTO getAdminByEmail(String email);
	
}
