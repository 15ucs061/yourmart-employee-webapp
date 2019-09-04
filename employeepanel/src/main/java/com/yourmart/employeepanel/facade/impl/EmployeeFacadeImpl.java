package com.yourmart.employeepanel.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yourmart.employeepanel.dto.ProductDto;
import com.yourmart.employeepanel.dto.SellerDto;
import com.yourmart.employeepanel.enums.EnumConstants.UserStatusEnums;
import com.yourmart.employeepanel.facade.EmployeeFacade;
import com.yourmart.employeepanel.service.EmployeeAuthentication;
import com.yourmart.employeepanel.service.ProductService;
import com.yourmart.employeepanel.service.UserService;

@Service
public class EmployeeFacadeImpl implements EmployeeFacade {

	@Autowired
	private EmployeeAuthentication auth;
	
	@Override
	public UserStatusEnums authenticateFacade(long employeeId, String password, String captchaResponse) {
		return auth.authenticate(employeeId,password,captchaResponse); 
	}

	@Autowired
	private UserService userService;
	
	@Override
	public List<SellerDto> displaySellerFacade() {
		return userService.getAllUsers();
	}

	@Autowired
	private ProductService productService;
	
	@Override
	public List<ProductDto> getProducts() {
		return productService.getAllProducts();
	}

	@Override
	public void updateSellerFacade(SellerDto seller) {
		userService.updateSeller(seller);
		
	}

	@Override
	public void updateProductFacade(ProductDto product) {
		productService.updateProductStatus(product);
	}

	
}
