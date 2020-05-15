package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Account;
import com.example.demo.repository.AccountRepository;

@Service
@Transactional
public class AccountServiceImpl implements AccountService{

	@Autowired
	AccountRepository accountRepository;
	
	@Override
	public List<Account> findAccountList() {
		return (List<Account>) accountRepository.findAll();
	}

	@Override
	public Optional<Account> FindAccountsByAccountNum(Long accountNumber) {
		// TODO Auto-generated method stub
		return accountRepository.findById(accountNumber);
	}

	@Override
	public Account save(@Valid Account account) {
		// TODO Auto-generated method stub
		return accountRepository.save(account);
	}

}
