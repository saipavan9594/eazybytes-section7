package com.example.section8accounts.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.section8accounts.model.Accounts;

public interface AccountsRepository extends CrudRepository<Accounts, Long> {
	
	Accounts findByCustomerId(int customerId);

}
