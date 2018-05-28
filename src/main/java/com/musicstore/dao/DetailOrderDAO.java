package com.musicstore.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.musicstore.entity.DetailOrder;
import com.musicstore.entity.Orders;
@Repository
public interface DetailOrderDAO  extends CrudRepository<DetailOrder, Integer>{
    @Query("select u from DetailOrder u where u.order.id = :idOrder and u.album.id = :idAlbum")
    public DetailOrder findByIdAlbum(@Param("idOrder") int idOrder, @Param("idAlbum") int idAlbum);
    @Query("delete from DetailOrder u where u.order.id = :id")
    public void deleteByOrder(@Param("id") int id);
}
