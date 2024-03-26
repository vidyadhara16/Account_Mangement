package com.example.BankApp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long Account_no;
	private String Account_holder_name;
	private Double Account_balance;
	
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Account(String account_holder_name, Double account_balance) {
		super();
		Account_holder_name = account_holder_name;
		Account_balance = account_balance;
	}

	public Long getAccount_no() {
		return Account_no;
	}
	public void setAccount_no(Long account_no) {
		Account_no = account_no;
	}
	public String getAccount_holder_name() {
		return Account_holder_name;
	}
	public void setAccount_holder_name(String account_holder_name) {
		Account_holder_name = account_holder_name;
	}
	public Double getAccount_balance() {
		return Account_balance;
	}
	public void setAccount_balance(Double account_balance) {
		Account_balance = account_balance;
	}
	
}
