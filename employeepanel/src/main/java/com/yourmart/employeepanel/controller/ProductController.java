package com.yourmart.employeepanel.controller;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yourmart.employeepanel.dto.ProductDto;
import com.yourmart.employeepanel.enums.EnumConstants.ProductStatusEnums;
import com.yourmart.employeepanel.facade.EmployeeFacade;

@Controller
public class ProductController {

	@Autowired
	private EmployeeFacade employeeFacade;

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@GetMapping(value = "/product")
	public ModelAndView products() {
		ModelAndView mav = new ModelAndView();
		List<ProductDto> productList = employeeFacade.getProducts();
		
		  for(ProductDto p:productList) {
		  LOGGER.info("product id : "+p.getCode()); }
		 
		mav.setViewName("products");
		mav.addObject("productList", productList);
		return mav;
	}
	
	@PostMapping(value = "/productStatus")
	public ModelAndView sellerUpdateControllerMethod(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		long code=Long.parseLong(request.getParameter("productCode"));
		ProductStatusEnums status=ProductStatusEnums.valueOf(request.getParameter("changedStatus"));
		LOGGER.info("status ======= " +status);
		ProductDto product=new ProductDto();
		product.setCode(code);
		product.setStatus(status);
		employeeFacade.updateProductFacade(product);
		mav.setViewName("redirect:/product");
		return mav;
	}
}
