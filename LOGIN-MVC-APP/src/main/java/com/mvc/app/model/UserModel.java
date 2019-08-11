package com.mvc.app.model;

import lombok.Data;

@Data
public class UserModel {
	private Long userId;
	private String userName;
	private String password;
	private String email;
	private String gender;
	private Long phno;
}
