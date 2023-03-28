package com.example.section7cards.model;

import javax.persistence.Id;

import lombok.Data;

@Data
public class Customer {
	
	@Id
	private int customerId;

}
