package com.yourmart.employeepanel.service;

import java.util.List;

import com.yourmart.employeepanel.dto.SellerDto;

public interface UserService {

	List<SellerDto> getAllUsers();
	
	void updateSeller(SellerDto seller);

}