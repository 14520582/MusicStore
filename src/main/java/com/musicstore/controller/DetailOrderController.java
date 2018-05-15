package com.musicstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.musicstore.entity.DetailOrder;
import com.musicstore.service.IDetailOrderService;

@RestController
@RequestMapping("/details")
public class DetailOrderController {
	@Autowired
	private IDetailOrderService detailorderService;
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value= "/all", method = RequestMethod.GET)
	public List<DetailOrder> findAll() {
		List<DetailOrder> list = detailorderService.findAll();
		return list;
	}
}
