package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Admin")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Admin {
	
//	@Id
//	@Column(name="Admin_username")
//	private String username;
	
//	@Column(length = 20, name = "Admin_password")
//	private String password;
	
	@Column(length = 20)
	private String firstName;
	@Column(length = 20)
	private String lastName;
	@Id
	@Column(unique = true, nullable = false)
	private String email;
	@Column(nullable = false)
	private String password;

	@Column(length = 10)
	private String phoneNo;

	@Column(length = 10)
	private String gender;

	@Lob // large object :col : longblob
	private byte[] image;

	@Column(unique = true)
	private String LinkedInLink;

	@Column(unique = true)
	private String GitHubLink;

	private String Heading;

	@Enumerated(EnumType.STRING)
	@Column(length = 30)
	private Role role = Role.ROLE_ADMIN;

}