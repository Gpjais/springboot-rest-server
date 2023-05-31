package com.jlcindia.springboot;

import java.util.List;

public interface AccountService {
	
	
	 public void addAccount(Account acc);
	 public void deposit(TxInfo txInfo); 
	 public void withdraw(TxInfo txInfo); 
	 public void deleteAccount(int accno);  
	 
	 public Account getAccountByAccno(int accno); 
	 public List<Account> getAllAccounts(); 
	 public List<Account> getAccountsByCity(String city); 
	 public List<Account> getAccountsByBcode(String bcode); 
  
}
