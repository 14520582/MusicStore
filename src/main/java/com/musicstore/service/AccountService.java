package com.musicstore.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.musicstore.dao.AccountDAO;
import com.musicstore.entity.Account;

@Service(value = "accountService")
public class AccountService implements UserDetailsService, IAccountService{
	@Autowired
	private AccountDAO accountDAO;
	@Override
	public Account getAccountById(int id) {
		Account obj = accountDAO.findOne(id);
		return obj;
	}
	private List<SimpleGrantedAuthority> getAuthority(String role) {
		return Arrays.asList(new SimpleGrantedAuthority(role));
	}
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		Account user = accountDAO.findByUserName(userId);
		if(user == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority(user.getRole()));
	}
	@Override
	public synchronized boolean addAccount(Account account) {
	       if (accountDAO.existsByUsername(account.getUsername())) {
	    	   return false;
	       } else {
	    	   accountDAO.save(account);
	    	   return true;
	       }
	}
	@Override
	public Account findOne(String username) {
		return accountDAO.findByUserName(username);
	}
	@Override
	public Account getAccountByUsername(String username) {
		Account obj = accountDAO.findByUserName(username);
		return obj; 
	}
	@Override
	public void update(Account acc) {
		accountDAO.save(acc);
	}

}
