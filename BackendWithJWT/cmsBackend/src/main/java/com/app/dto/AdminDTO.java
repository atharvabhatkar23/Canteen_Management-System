package com.app.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.app.entities.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AdminDTO {
	@JsonProperty(access = Access.READ_ONLY)
	private Long id;

	@NotBlank
	private String firstName;

	@NotBlank
	private String lastName;

	@Email
	private String email;

	@JsonIgnore
	private String password;

	private String phoneNo;

	private String gender;

	private String imageUrl;

	private String LinkedInLink;

	private String GitHubLink;

	private String Heading;
	
	private Role role;
}
