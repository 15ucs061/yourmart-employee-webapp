package com.yourmart.employeepanel.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.yourmart.employeepanel.dto.ProductDto;
import com.yourmart.employeepanel.dto.SellerDto;
import com.yourmart.employeepanel.enums.EnumConstants.UserStatusEnums;
import com.yourmart.employeepanel.facade.EmployeeFacade;

@RestController
public class HomeController {

	@Autowired
	private EmployeeFacade employeeFacade;

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping(value = "/employeeHome")
	public ModelAndView displayControllerMethod(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		List<SellerDto> sellerList = employeeFacade.displaySellerFacade();
		
		  for(SellerDto s:sellerList) {
		  LOGGER.info("seller id : "+s.getUserId()); }
		 
		mav.setViewName("home");
		mav.addObject("sellerList", sellerList);
		return mav;
	}
	
	@PostMapping(value = "/status")
	public ModelAndView sellerUpdateControllerMethod(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		long sellerId=Long.parseLong(request.getParameter("sellerId"));
		UserStatusEnums status=UserStatusEnums.valueOf(request.getParameter("changedStatus"));
		LOGGER.info("status ======= " +status);
		SellerDto seller=new SellerDto();
		seller.setUserId(sellerId);
		seller.setStatus(status);
		employeeFacade.updateSellerFacade(seller);
		mav.setViewName("redirect:/employeeHome");
		return mav;
	}

}
