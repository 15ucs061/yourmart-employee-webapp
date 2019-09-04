package com.yourmart.employeepanel.restserviceinterface;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.yourmart.employeepanel.dto.EmployeeCredentialsDto;
import com.yourmart.employeepanel.dto.ProductDto;
import com.yourmart.employeepanel.dto.SellerDto;

@FeignClient("product-management-service")
public interface SellerAndProductManagementClient {
	
	@GetMapping("/products")
	public List<ProductDto> getAllProducts();
	
	@GetMapping("/products/{productCode}")
	public ProductDto getProduct(@PathVariable("productCode") long productCode);

	@GetMapping("/products/sellers/{sellerId}")
	public List<ProductDto> getProducts(@PathVariable("sellerId") long sellerId);
	
	@GetMapping("/users/authentication")
	public String check(@RequestParam("id") long id,@RequestParam("password") String password,@RequestParam("g-captcha-response") String captchaResponse);
	
	@GetMapping("/users/sellers")
	public List<SellerDto> getAllSellers();
	
	@PutMapping("/users/update")
	public void updateEmployee(@RequestBody SellerDto seller);
	
	@PutMapping("/products/updateStatus")
	public void updateProductStatus(@RequestBody ProductDto product);

}
