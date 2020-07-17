package com.cos.blog.repository;

import java.util.List;

import com.cos.blog.model.Account;

public interface AccountRepository {
	
	public void update(Account account);
	public List<Account> findAll();
	public Account findByAccountNumber(String accountNumber);
}
