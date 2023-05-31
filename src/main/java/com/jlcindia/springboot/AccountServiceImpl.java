package com.jlcindia.springboot;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl  implements AccountService{
 
	@Autowired
	AccountRepository accrepo;
	
	@Override
	public void addAccount(Account acc) {
		// TODO Auto-generated method stub
		accrepo.save(acc);
	}

	@Override
	public void deposit(TxInfo txInfo) {
		// TODO Auto-generated method stub
		Optional<Account> op= accrepo.findById(txInfo.getAccno());
		if(op.isPresent())
		{
			Account acc=op.get();
			double updatedBal=acc.getBalance()+txInfo.getAmount();
			acc.setBalance(updatedBal);
			accrepo.save(acc);
		}
		
	}

	@Override
	public void withdraw(TxInfo txInfo) {
		// TODO Auto-generated method stub
	Optional<Account> opw =accrepo.findById(txInfo.getAccno());
	if(opw.isPresent()) {
		Account accw=opw.get();
		double updateamoutn=accw.getBalance()-txInfo.getAmount();
		accw.setBalance(updateamoutn);
		accrepo.save(accw);
		
	}
		
		
	}

	@Override
	public void deleteAccount(int accno) {
		// TODO Auto-generated method stub
		Optional<Account>accdel= accrepo.findById(accno);
		if(accdel.isPresent())
		{
		       Account ac=accdel.get();
		       accrepo.deleteById(accno);
		}
		
	}

	@Override
	public Account getAccountByAccno(int accno) {
		// TODO Auto-generated method stub
		Optional<Account> acc=accrepo.findById(accno);
		if(acc.isPresent())
		{
			Account acc1=acc.get();
			System.out.println(acc1);
		}
		return null;
	}

	@Override
	public List<Account> getAllAccounts() {
		// TODO Auto-generated method stub
		List<Account> myaccountlist=accrepo.findAll();
		for(Account myaccountlists:myaccountlist)
		{
			System.out.println(myaccountlists);
		}
		return myaccountlist;
	}

	@Override
	public List<Account> getAccountsByCity(String city) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> getAccountsByBcode(String bcode) {
		// TODO Auto-generated method stub
		return null;
	}

}
