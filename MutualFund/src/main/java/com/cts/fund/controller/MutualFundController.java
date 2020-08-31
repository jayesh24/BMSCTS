package com.cts.fund.controller;
import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.fund.api.FeignClient;
import com.cts.fund.model.Account;
import com.cts.fund.model.Dto;
import com.cts.fund.model.MutualFund;
import com.cts.fund.response.Response;
import com.cts.fund.service.MutualFundService;
import com.cts.fund.validation.Validate;
import com.google.inject.spi.Message;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class MutualFundController {

	@Autowired
	MutualFundService service;
	@Autowired
	FeignClient feign;
	@PostMapping("/create")
	public ResponseEntity<Response> createFunds(
			@RequestBody MutualFund data) {
		Response response = new Response();
		HttpStatus status = HttpStatus.CREATED;
		MutualFund fund = new MutualFund();

		try {
//			checking for blank data
			if (Validate.check(data.getName())) {
				status = HttpStatus.BAD_REQUEST;
				response.setMgs("MutualFund Name can't be blank");
				return new ResponseEntity<Response>(response, status);
			}

			fund.setName((data.getName()));
			fund.setAmountToInvest(data.getAmountToInvest());
			fund.setFundId(UUID.randomUUID().toString());
			fund.setTimeStamp(LocalDate.now());
			service.createFund(fund);

			response.setMgs("MutualFund Successfully created");

		} catch (Exception e) {
			response.setMgs("Amount cant be null ");
		}

		return new ResponseEntity<Response>(response, status);
	}
	
	@GetMapping("/fundid/{id}")
	@HystrixCommand(fallbackMethod="ListOfProductByID_FallBack")
	Optional<Dto> getById(@PathVariable(value = "id") int id){
		Dto dto = new Dto();
		MutualFund fund = service.findById(id).get();
		dto.setId(fund.getId());
		dto.setFundId(fund.getFundId());
		dto.setName(fund.getName());
		dto.setTimeStamp(fund.getTimeStamp());
		dto.setAmountToInvest(fund.getAmountToInvest());
		dto.setAccount(findById(id));
		return Optional.of(dto);
	}
	
	@GetMapping("/id/{id}")
	public Optional<Account> findById(@PathVariable(value="id")int id){
			
			return feign.findById(id);
		}
	
	public Optional<Dto> ListOfProductByID_FallBack(@PathVariable("/fundid/{id}") int id) throws InterruptedException
	{//logging
		String methodName = "ListOfProductByID_FallBack()";
//	   	logger.info(methodName+" called");
	   	Thread.sleep(4000);
		return null;
	}
}
