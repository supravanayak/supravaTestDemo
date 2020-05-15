package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.example.demo.model.Account;

public interface AccountService {
	List<Account> findAccountList();

	Optional<Account> FindAccountsByAccountNum(Long accountNumber);

	Account save(@Valid Account account);
}
