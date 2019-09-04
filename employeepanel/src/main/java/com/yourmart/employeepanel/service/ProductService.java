package com.yourmart.employeepanel.service;

import java.util.List;

import com.yourmart.employeepanel.dto.ProductDto;

public interface ProductService {

	List<ProductDto> getAllProducts();

	void updateProductStatus(ProductDto product);

}