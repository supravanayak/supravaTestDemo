package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Account;
import com.example.demo.service.AccountService;

@RestController
@RequestMapping("api/v2")
public class AccountController {

	@Autowired
	AccountService accountService;
	
	@GetMapping("/Account")
	public List<Account> getAllAccount(){
		return accountService.findAccountList();
	}
	
	@GetMapping("/Account/{id}")
	public Account getAccountByAccountNum(@PathVariable (value= "id") Long AccountNumber) throws ResourceNotFoundException {
		 Optional<Account> acc = accountService.FindAccountsByAccountNum(AccountNumber);
		 return acc.orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + AccountNumber));	
	}
	
	@PostMapping("/Accounts")
	public Account saveAccount(@Valid @RequestBody Account account) {
		return accountService.save(account);
	}
}
