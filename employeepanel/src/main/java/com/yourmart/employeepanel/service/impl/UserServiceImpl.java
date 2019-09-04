package com.yourmart.employeepanel.service.impl;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yourmart.employeepanel.dto.SellerDto;
import com.yourmart.employeepanel.restserviceinterface.SellerAndProductManagementClient;
import com.yourmart.employeepanel.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private SellerAndProductManagementClient productManagementClient;
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	private Comparator<SellerDto> idComparator=Comparator.comparing(SellerDto::getUserId);
	
	@Override
	public List<SellerDto> getAllUsers() {
		//List<SellerDto> list=productManagementClient.getAllSellers().stream().sorted(idComparator).collect(Collectors.toList());
		final Predicate<SellerDto> needApprovalPredicate=seller->seller.getStatus().toString().equals("NEED_APPROVAL");
		final Predicate<SellerDto> approvedPredicate=seller->seller.getStatus().toString().equals("APPROVED");
		final Predicate<SellerDto> rejectedPredicate=seller->seller.getStatus().toString().equals("REJECTED");
		List<SellerDto> finalList=new LinkedList<SellerDto>();
		finalList.addAll(productManagementClient.getAllSellers().stream().filter(needApprovalPredicate).sorted(idComparator).collect(Collectors.toList()));
		finalList.addAll(productManagementClient.getAllSellers().stream().filter(approvedPredicate).sorted(idComparator).collect(Collectors.toList()));
		finalList.addAll(productManagementClient.getAllSellers().stream().filter(rejectedPredicate).sorted(idComparator).collect(Collectors.toList()));
		LOGGER.info("List=== "+finalList);
		return finalList;
	}

	@Override
	public void updateSeller(SellerDto seller) {
		productManagementClient.updateEmployee(seller);
		
	}
	
	

}
