package com.example.section8cards.model;

import javax.persistence.Id;

import lombok.Data;

@Data
public class Customer {
	
	@Id
	private int customerId;

}
