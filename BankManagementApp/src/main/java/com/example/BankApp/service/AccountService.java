package com.example.BankApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BankApp.entity.Account;
import com.example.BankApp.repository.AccountRepository;

@Service
public class AccountService {
	@Autowired
	private AccountRepository accountRepository;
	
	
	public Account createAccount(Account account) {
		Account createdAccount=accountRepository.save(account);
		return createdAccount;
	}
	
	public Account getAccountDetails(Long account_no) {
		Optional<Account> details=accountRepository.findById(account_no);
		if(details.isEmpty()) {
			throw new RuntimeException("Account does not exist!!!!");
		}else {
			Account Account_found=details.get();
			return Account_found;
		}
		
		
		
	}
	public List<Account> AllAccountDetails() {
		
		List<Account> list=accountRepository.findAll();
	
		return list;
		
		
	}
	public Account Deposit(Long account_no,Double amount) {
		Optional<Account> details1=accountRepository.findById(account_no);
		if(details1.isEmpty()) {
			throw new RuntimeException("Account does not exist!!!!");
		}
		else {
			Account Account_found1=details1.get();
			Double totalbal=Account_found1.getAccount_balance()+amount;
			Account_found1.setAccount_balance(totalbal);
			accountRepository.save(Account_found1);
			return Account_found1;
		}
		
		
	}
	public Account withdraw(Long account_no,Double amount) {
		Optional<Account> details2=accountRepository.findById(account_no);
		if(details2.isEmpty()) {
			throw new RuntimeException("Account does not exist!!!!");
		}
		else {
			Account Account_found2=details2.get();
			Double totalbal1=Account_found2.getAccount_balance()-amount;
			Account_found2.setAccount_balance(totalbal1);
			accountRepository.save(Account_found2);
			return Account_found2;
		}
		
	}
	public void close(Long account_no) {
		 getAccountDetails(account_no);
		 accountRepository.deleteById(account_no);
	}

}
