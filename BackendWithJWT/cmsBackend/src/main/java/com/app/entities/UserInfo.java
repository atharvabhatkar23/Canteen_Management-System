package com.app.entities;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserInfo  {

	public UserInfo(String email, String password, Role role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	@Column(unique = true)
	private String email;
	private String password;
	@Enumerated(EnumType.STRING)
	@Column(length = 30)
	private Role role;
}
