package com.app.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SigninResponse<T> {

	private String jwt;
	private String mesg;
	private T userDetails;

	public SigninResponse(String jwt, String mesg, T userDetails) {
		this.jwt = jwt;
		this.mesg = mesg;
		this.userDetails = userDetails;
	}
}
