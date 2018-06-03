package com.musicstore.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.musicstore.entity.Orders;

public interface IOrderService {
	List<Orders> findAll();
	Orders findById(int id);
	void addOrder(Orders order);
	List<Orders> findByStatus(int status);
	List<Orders> findByUser(int id);
	List<Orders> findOrdered();
	List<Orders> findCartByUsername(String username);
	List<Orders> findOrdersByUsername(String username);
	void book(int id);
	Orders save(Orders order);
	Page<Orders> findByPage(Pageable pageable);
	Page<Orders> findByPageByStatus(int status,Pageable pageable);
	Page<Orders> findBySearchTerm(String term, Pageable pageable);
	Page<Orders> findBySearchTermByStatus(String term, int status, Pageable pageable);
}
