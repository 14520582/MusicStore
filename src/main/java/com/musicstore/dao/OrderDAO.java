package com.musicstore.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.musicstore.entity.Order;

@Repository
public interface OrderDAO extends CrudRepository<Order, Integer>{

}
