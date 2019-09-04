package com.yourmart.employeepanel.facade;

import java.util.List;

import com.yourmart.employeepanel.dto.ProductDto;
import com.yourmart.employeepanel.dto.SellerDto;
import com.yourmart.employeepanel.enums.EnumConstants.UserStatusEnums;

public interface EmployeeFacade {

	UserStatusEnums authenticateFacade(long employeeId, String password, String captchaResponse);
	List<SellerDto> displaySellerFacade();
	List<ProductDto> getProducts();
	void updateSellerFacade(SellerDto seller);
	void updateProductFacade(ProductDto product);

}