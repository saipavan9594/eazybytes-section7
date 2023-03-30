package com.example.section8accounts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.section8accounts.config.AccountsServiceConfig;
import com.example.section8accounts.model.Accounts;
import com.example.section8accounts.model.Cards;
import com.example.section8accounts.model.Customer;
import com.example.section8accounts.model.CustomerDetails;
import com.example.section8accounts.model.Loans;
import com.example.section8accounts.model.Properties;
import com.example.section8accounts.repository.AccountsRepository;
import com.example.section8accounts.service.client.CardsFeignClient;
import com.example.section8accounts.service.client.LoansFeignClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@RestController
public class AccountsController {
	
	@Autowired
	private AccountsRepository accountsRepository;
	
	@Autowired
	AccountsServiceConfig accountsConfig;
	
	@Autowired
	LoansFeignClient loansFeignClient;
	
	@Autowired
	CardsFeignClient cardsFeignClient;
	
	
	@PostMapping("/myAccount")
	public Accounts getAccountDetails(@RequestBody Customer customer) {
		
		Accounts accounts=accountsRepository.findByCustomerId(customer.getCustomerId());
		if(accounts!=null) {
			return accounts;
		}
		else
			return null;
	}
	
	@GetMapping(path="/accounts/properties", produces = MediaType.APPLICATION_JSON_VALUE)
	public String getPropertyDetails() throws JsonProcessingException {
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		Properties properties = new Properties(accountsConfig.getMsg(), accountsConfig.getBuildVersion(),
				accountsConfig.getMailDetails(), accountsConfig.getActiveBranches());
		String jsonStr = ow.writeValueAsString(properties);
		return jsonStr;
	}
	

	@PostMapping("/myCustomerDetails")
	public CustomerDetails myCustomerDetails(@RequestBody Customer customer) {
		
		Accounts accounts=accountsRepository.findByCustomerId(customer.getCustomerId());
		List<Cards> cards=cardsFeignClient.getCardDetails(customer);
		List<Loans> loans=loansFeignClient.getLoanDetails(customer);
		
		CustomerDetails customerDetails= new CustomerDetails();
		customerDetails.setAccounts(accounts);
		customerDetails.setCards(cards);
		customerDetails.setLoans(loans);
		
		return customerDetails;
	}

}
