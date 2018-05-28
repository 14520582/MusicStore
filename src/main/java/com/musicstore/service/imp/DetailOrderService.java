package com.musicstore.service.imp;
import com.musicstore.service.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musicstore.dao.DetailOrderDAO;
import com.musicstore.entity.DetailOrder;
@Service(value = "detailorderService")
public class DetailOrderService implements IDetailOrderService{
	@Autowired
	private DetailOrderDAO detailorderDAO;
	@Override
	public List<DetailOrder> findAll() {
		return (List<DetailOrder>) detailorderDAO.findAll();
	}
	@Override
	public void deleteDetail(int id) {
		detailorderDAO.delete(id);	
	}
	@Override
	public void addDetail(DetailOrder a) {	
		detailorderDAO.save(a);
	}
	@Override
	public DetailOrder findByIdAlbum(int idOrder, int idAlbum) {
		// TODO Auto-generated method stub
		return detailorderDAO.findByIdAlbum(idOrder, idAlbum);
	}
	@Override
	public void deleteByOrder(int id) {
		// TODO Auto-generated method stub
		detailorderDAO.deleteByOrder(id);
	}

}
