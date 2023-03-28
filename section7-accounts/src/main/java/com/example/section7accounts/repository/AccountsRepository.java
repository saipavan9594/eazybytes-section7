package com.example.section7accounts.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.section7accounts.model.Accounts;

public interface AccountsRepository extends CrudRepository<Accounts, Long> {
	
	Accounts findByCustomerId(int customerId);

}
