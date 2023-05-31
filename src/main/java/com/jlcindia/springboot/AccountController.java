package com.jlcindia.springboot;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

	@Autowired
	AccountService accountService;
	
	@PostMapping("/addAccount") 
	public String addAccount(@RequestBody Account acc) { 
	System.out.println("AC-addAccount()"); 
	accountService.addAccount(acc); 
	String msg = "Account Added successfully"; 
	return msg; 
	} 
	
	@PutMapping(value="/mydeposit")
	public  String deposite(@RequestBody TxInfo txInfo)
	{
	    accountService.deposit(txInfo);
		return "Amount deposited Successfully.";
	}
	
	@PutMapping(value="/mywithdraw")
	public  String withdraw(@RequestBody TxInfo txInfo)
	{
	    accountService.withdraw(txInfo);
		return "Amount withdrawan Successfully.";
	}
	
	@DeleteMapping(value="/delete/{accno}")
	public  String delete(@PathVariable  int accno)
	{
	    accountService.deleteAccount(accno);
		return "Amount withdrawan Successfully.";
	}
}
