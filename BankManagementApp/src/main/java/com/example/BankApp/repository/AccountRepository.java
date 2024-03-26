package com.example.BankApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.BankApp.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long>{

	
}
