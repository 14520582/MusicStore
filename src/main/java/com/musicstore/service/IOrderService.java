package com.musicstore.service;

import java.util.List;

import com.musicstore.entity.Orders;

public interface IOrderService {
	List<Orders> findAll();
	Orders findById(int id);
	void addOrder(Orders order);
	List<Orders> findByStatus(int status);
	List<Orders> findOrdered();
	List<Orders> findCartByUsername(String username);
	List<Orders> findOrdersByUsername(String username);
	void book(int id);
	Orders save(Orders order);
}
