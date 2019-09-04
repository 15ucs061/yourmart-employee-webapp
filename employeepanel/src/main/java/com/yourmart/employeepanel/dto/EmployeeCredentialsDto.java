package com.yourmart.employeepanel.dto;

import com.yourmart.employeepanel.enums.EnumConstants.UserStatusEnums;

public class EmployeeCredentialsDto {

	private long userId;
	private String password;
	private UserStatusEnums status;
	
	public UserStatusEnums getStatus() {
		return status;
	}
	public void setStatus(UserStatusEnums status) {
		this.status = status;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long empoyeeId) {
		this.userId = empoyeeId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
