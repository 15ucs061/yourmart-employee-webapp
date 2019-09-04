package com.yourmart.employeepanel.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.yourmart.employeepanel.enums.EnumConstants.UserStatusEnums;
import com.yourmart.employeepanel.facade.EmployeeFacade;


@RestController
public class LoginController {

	@Autowired
	private EmployeeFacade employeeFacade;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

	@GetMapping("/login")
	public ModelAndView init(HttpServletRequest request,HttpServletResponse response) {
		System.out.println("------------------------------");
		ModelAndView mav=new ModelAndView(); 
		mav.setViewName("login");
		return mav;
	}
	
	@PostMapping(value = "/login")
	public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mav = new ModelAndView();
		long employeeId = Long.parseLong(request.getParameter("employeeId"));
		String password = request.getParameter("password");
		String captchaResponse=request.getParameter("g-recaptcha-response");
		LOGGER.info("captcha=  "+captchaResponse);
		HttpSession session = request.getSession();
		session.setAttribute("facade", employeeFacade);
		UserStatusEnums status=employeeFacade.authenticateFacade(employeeId, password,captchaResponse);
		LOGGER.info("status1111=  "+status);
		if (status.equals(UserStatusEnums.APPROVED)) {
			LOGGER.info("status1111=  "+status);
			session.setAttribute("employeeId", employeeId);
			mav.setViewName("redirect:/employeeHome");
		} else {
			request.setAttribute("msg", status.toString());
			mav.setViewName("login");
		}
		return mav;
	}
}
