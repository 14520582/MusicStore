package com.musicstore.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.musicstore.entity.Orders;

@Repository
public interface OrderDAO extends CrudRepository<Orders, Integer>{
    @Query("select u from Orders u where u.status = 1")
    public List<Orders> findOrdered();
    @Query("select u from Orders u where u.customer.username = :username and u.status = 0")
    public List<Orders> findCartByUsername(@Param("username") String username);
    @Query("select u from Orders u where u.customer.username = :username and u.status = 1")
    public List<Orders> findOrderByUsername(@Param("username") String username);
    @Modifying
    @Query("update Orders u set u.status = 1 where u.id=:id")
    public void book(@Param("id") int id);
    @Query("select u from Orders u where u.status = :status")
    public List<Orders> findByStatus(@Param("status") int status);
}
