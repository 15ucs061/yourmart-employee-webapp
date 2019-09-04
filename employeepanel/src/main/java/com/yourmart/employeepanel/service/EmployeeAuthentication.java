package com.yourmart.employeepanel.service;

import com.yourmart.employeepanel.enums.EnumConstants.UserStatusEnums;

public interface EmployeeAuthentication {

	UserStatusEnums authenticate(long employeeId, String password, String captchaResponse);

}