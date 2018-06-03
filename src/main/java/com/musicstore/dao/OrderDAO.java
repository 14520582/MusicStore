package com.musicstore.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.musicstore.entity.Album;
import com.musicstore.entity.Orders;

@Repository
public interface OrderDAO extends CrudRepository<Orders, Integer>{
    @Query("select u from Orders u where u.status = 1")
    public List<Orders> findOrdered();
    @Query("select u from Orders u where u.customer.username = :username and u.status = 0")
    public List<Orders> findCartByUsername(@Param("username") String username);
    @Query("select u from Orders u where u.customer.id = :id")
    public List<Orders> findByUser(@Param("id") int id);
    @Query("select u from Orders u where u.customer.username = :username and u.status = 1")
    public List<Orders> findOrderByUsername(@Param("username") String username);
    @Modifying
    @Query("update Orders u set u.status = 1 where u.id=:id")
    public void book(@Param("id") int id);
    @Query("select u from Orders u where u.status = :status")
    public List<Orders> findByStatus(@Param("status") int status);
    public Page<Orders> findAll(Pageable page);
    @Query("SELECT t FROM Orders t WHERE t.status = :status")
    public Page<Orders> findAllByStatus(@Param("status") int status, Pageable page);
    @Query("SELECT t FROM Orders t WHERE " +
            "LOWER(t.name) LIKE LOWER(CONCAT('%',:searchTerm, '%')) OR " +
            "LOWER(t.phone) LIKE LOWER(CONCAT('%',:searchTerm, '%')) OR " +
            "LOWER(CONCAT(t.id,'')) LIKE LOWER(CONCAT('%',:searchTerm, '%'))")
    public Page<Orders> findBySearchTerm(@Param("searchTerm") String searchTerm, Pageable pageable);
    @Query("SELECT t FROM Orders t WHERE " +
            "LOWER(t.name) LIKE LOWER(CONCAT('%',:searchTerm, '%')) OR " +
            "LOWER(t.phone) LIKE LOWER(CONCAT('%',:searchTerm, '%')) OR " +
            "LOWER(CONCAT(t.id,'')) LIKE LOWER(CONCAT('%',:searchTerm, '%')) AND " +
            "t.status = :status")
    public Page<Orders> findBySearchTermAndStatus(@Param("searchTerm") String searchTerm, @Param("status") int status, Pageable pageable);
}
