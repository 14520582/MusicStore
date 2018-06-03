package com.musicstore.service.imp;
import com.musicstore.service.*;
import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	@Override
	public List<Orders> findByStatus(int status) {
		// TODO Auto-generated method stub
		return orderDAO.findByStatus(status);
	}
	@Override
	public Orders save(Orders order) {
		return orderDAO.save(order);
	}
	@Override
	public Page<Orders> findByPage(Pageable pageable) {
		// TODO Auto-generated method stub
		return orderDAO.findAll(pageable);
	}
	@Override
	public Page<Orders> findBySearchTerm(String term, Pageable pageable) {
		// TODO Auto-generated method stub
		return orderDAO.findBySearchTerm(term, pageable);
	}
	@Override
	public Page<Orders> findByPageByStatus(int status, Pageable pageable) {
		// TODO Auto-generated method stub
		return orderDAO.findAllByStatus(status, pageable);
	}
	@Override
	public Page<Orders> findBySearchTermByStatus(String term, int status, Pageable pageable) {
		// TODO Auto-generated method stub
		return orderDAO.findBySearchTermAndStatus(term, status, pageable);
	}
	@Override
	public List<Orders> findByUser(int id) {
		// TODO Auto-generated method stub
		return orderDAO.findByUser(id);
	}
}
