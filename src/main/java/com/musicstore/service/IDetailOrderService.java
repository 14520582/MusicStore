package com.musicstore.service;

import java.util.List;

import com.musicstore.entity.DetailOrder;

public interface IDetailOrderService {
	List<DetailOrder> findAll();
	void deleteDetail(int id);
	void addDetail(DetailOrder a);
	DetailOrder findByIdAlbum(int idOrder, int idAlbum);
}
