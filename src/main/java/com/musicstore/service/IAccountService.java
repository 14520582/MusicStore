package com.musicstore.service;


import com.musicstore.entity.Account;

public interface IAccountService {
     	Account getAccountById(int id);
     	Account getAccountByUsername(String username);
     	boolean addAccount(Account account);
     	Account findOne(String username);
     	void update(Account acc);
}