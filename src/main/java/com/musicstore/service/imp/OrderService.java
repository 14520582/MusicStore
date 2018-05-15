package com.musicstore.service.imp;
import com.musicstore.service.*;
import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.musicstore.dao.OrderDAO;
import com.musicstore.entity.Orders;

@Service(value = "orderService")
public class OrderService implements IOrderService {
	@Autowired
	private OrderDAO orderDAO;
	@Override
	public List<Orders> findAll() {
		return (List<Orders>) orderDAO.findAll();
		
		
	}
	@Override
	public Orders findById(int id) {
		return orderDAO.findOne(id);
	}
	@Override
	public void addOrder(Orders order) {
		orderDAO.save(order);
	}
	@Override
	public List<Orders> findOrdered() {
		return (List<Orders>) orderDAO.findOrdered();
	}
	@Override
	public List<Orders> findCartByUsername(String username) {
		// TODO Auto-generated method stub
		return (List<Orders>) orderDAO.findCartByUsername(username);
	}
	@Override
	public List<Orders> findOrdersByUsername(String username) {
		// TODO Auto-generated method stub
		return (List<Orders>) orderDAO.findOrderByUsername(username);
	}
	@Override
	public void book(int id) {
		orderDAO.book(id);	
	}

}
