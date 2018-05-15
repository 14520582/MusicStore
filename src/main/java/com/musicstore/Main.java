package com.musicstore;

import java.util.Date;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.musicstore.dao.AlbumDAO;
public class Main {
	public static void main(String[] args) {
//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//		System.out.println(encoder.encode("m123"));
		Date a = new Date();
		System.out.println(a.getTime());
	}
}
