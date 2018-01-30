package com.musicstore.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.musicstore.entity.Account;

import com.musicstore.service.IAccountService;

@RestController
@RequestMapping("/info")
public class AccountController {
	@Autowired
	private IAccountService accountService;

    private BCryptPasswordEncoder bCryptPasswordEncoder;
	@RequestMapping(value="/account/{id}", method = RequestMethod.GET )
	public ResponseEntity<Account> getAccountById(@PathVariable("id") Integer id) {
		Account acc = accountService.getAccountById(id);
		return new ResponseEntity<Account>(acc, HttpStatus.OK);
	}
	@RequestMapping(value="/account/get/{username}", method = RequestMethod.GET )
	public ResponseEntity<Account> getAccountByUsername(@PathVariable("username") String username) {
		Account acc = accountService.getAccountByUsername(username);
		return new ResponseEntity<Account>(acc, HttpStatus.OK);
	}
	@RequestMapping(value="/home")
	public String home(ModelMap model, Authentication authentication) {
		authentication.getPrincipal();
		model.addAttribute("user", accountService.getAccountByUsername(authentication.getName()));
 		return "user-info";
 	}
	@RequestMapping(value="/error")
	public String error() {
 		return "access-denied";
 	}
//	@RequestMapping(value= "/account", method = RequestMethod.GET)
//	public ResponseEntity<List<Account>> getAllAccounts() {
//		List<Account> list = accountService.getAllAccounts();
//		return new ResponseEntity<List<Account>>(list, HttpStatus.OK);
//	}
	@RequestMapping(value= "/account", method = RequestMethod.POST)
	public ResponseEntity<Void> addAccount(@RequestBody Account account, UriComponentsBuilder builder) {
		account.setPassword(bCryptPasswordEncoder.encode(account.getPassword()));
		boolean flag = accountService.addAccount(account);
        if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/account/{id}").buildAndExpand(account.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
//	@RequestMapping(value="/account/{id}", method = RequestMethod.PUT )
//	public ResponseEntity<Account> updateAccount(@RequestBody Account acc) {
//		accountService.updateAccount(acc);
//		return new ResponseEntity<Account>(acc, HttpStatus.OK);
//	}
//	@RequestMapping(value="/account/{id}", method = RequestMethod.DELETE )
//	public ResponseEntity<Void> deleteAccount(@PathVariable("id") Integer id) {
//		accountService.deleteAccount(id);
//		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
//	}	
}
