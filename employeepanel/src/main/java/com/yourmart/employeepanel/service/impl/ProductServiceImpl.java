package com.yourmart.employeepanel.service.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yourmart.employeepanel.dto.ProductDto;
import com.yourmart.employeepanel.restserviceinterface.SellerAndProductManagementClient;
import com.yourmart.employeepanel.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private SellerAndProductManagementClient productManagementClient;
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Override
	public List<ProductDto> getAllProducts(){
		List<ProductDto> list=productManagementClient.getAllProducts();
		LOGGER.info("List=== "+list);
		return list;
	}

	@Override
	public void updateProductStatus(ProductDto product) {
		LocalDate todayLocalDate=LocalDate.now();
		DateTimeFormatter sdf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    String date = sdf.format(todayLocalDate);
	    LOGGER.info("date:  "+date);
	    product.setCreationDate(date);
		productManagementClient.updateProductStatus(product);
	}

}
