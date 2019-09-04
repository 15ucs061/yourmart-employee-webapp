package com.yourmart.employeepanel.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yourmart.employeepanel.dto.EmployeeCredentialsDto;
import com.yourmart.employeepanel.enums.EnumConstants.RoleEnums;
import com.yourmart.employeepanel.enums.EnumConstants.UserStatusEnums;
import com.yourmart.employeepanel.restserviceinterface.SellerAndProductManagementClient;
import com.yourmart.employeepanel.service.EmployeeAuthentication;

@Service
public class EmployeeAuthenticationImpl implements EmployeeAuthentication {

	@Autowired
	private SellerAndProductManagementClient productManagementClient;

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Override
	public UserStatusEnums authenticate(long employeeId, String password, String captchaRepsonse) {

		String status = productManagementClient.check(employeeId,password,captchaRepsonse);

		LOGGER.info("status=== " + status);
		if (status.contains(UserStatusEnums.NOT_A_HUMAN.toString())) {
			return UserStatusEnums.NOT_A_HUMAN;
		} else {
			String role=status.substring(status.indexOf("-")+1);
			LOGGER.info("role===== " +role);
			if(role.equals(RoleEnums.ADMIN.toString())) {
				return UserStatusEnums.valueOf(status.substring(0,status.indexOf("-")));
			}
			else {
				return UserStatusEnums.NOT_REGISTERED;
			}
		}
	}

}
