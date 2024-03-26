package com.example.BankApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BankApp.entity.Account;
import com.example.BankApp.service.AccountService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountService service;
	@PostMapping("/create")
	public ResponseEntity<Account> createAccount(@RequestBody Account account) {
		
		Account createAccount=service.createAccount(account);
		return ResponseEntity.status(HttpStatus.CREATED).body(createAccount);
		
		
	}
	@GetMapping("/{account_no}")
	public Account getbyaccountnumber(@PathVariable Long account_no) {
		Account AccountInfo=service.getAccountDetails(account_no);
		return AccountInfo ;
	}
	
	@GetMapping("/all_accounts")
	public List<Account> getallAccounts() {
		List<Account> Full=service.AllAccountDetails();
		return Full;
	}
	
	@PutMapping("deposit/{account_no}/{amount}")
	public Account depositAmt(@PathVariable Long account_no, @PathVariable Double amount) {
		Account AccountDeposited=service.Deposit(account_no, amount);
		
		return AccountDeposited;
	}
	
	@PutMapping("withdraw/{account_no}/{amount}")
	public Account withdrawAmt(@PathVariable Long account_no, @PathVariable Double amount) {
		Account AccountWithdrawn=service.withdraw(account_no, amount);
		
		return AccountWithdrawn;
	}
	
	@DeleteMapping("/delete/{account_no}")
	public  ResponseEntity<String> deleteAccount(@PathVariable Long account_no) {
		service.close(account_no);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Account is Closed!!!");
	}
}
