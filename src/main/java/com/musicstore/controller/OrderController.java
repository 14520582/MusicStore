package com.musicstore.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.musicstore.entity.Account;
import com.musicstore.entity.Album;
import com.musicstore.entity.DetailOrder;
import com.musicstore.entity.Orders;
import com.musicstore.entity.Song;
import com.musicstore.service.IAccountService;
import com.musicstore.service.IAlbumService;
import com.musicstore.service.IArtistService;
import com.musicstore.service.IDetailOrderService;
import com.musicstore.service.IOrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	@Autowired
	private IOrderService orderService;
	@Autowired
	private IArtistService artistService;
	@Autowired
	private IAccountService accountService;
	@Autowired
	private IDetailOrderService detailOrderService;
	@Autowired
	private IAlbumService albumService;
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value= "/all", method = RequestMethod.GET)
	public List<Orders> findAll() {
		List<Orders> list = orderService.findAll();
		return list;
	}
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value= "/ordered", method = RequestMethod.GET)
	public List<Orders> findOrdered() {
		List<Orders> list = orderService.findOrdered();
		return list;
	}
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public Page<Orders> findBySearchTerm(@RequestParam("page") int page, @RequestParam("pagesize") int pageSize, @RequestParam("term") String term) {
    	Pageable pageable = new PageRequest(page, pageSize);
    	return orderService.findBySearchTerm(term, pageable);
    }
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @RequestMapping(value = "/searchandstatus", method = RequestMethod.GET)
    public Page<Orders> findBySearchTermAndStatus(@RequestParam("page") int page, @RequestParam("pagesize") int pageSize, @RequestParam("term") String term, @RequestParam("status") int status) {
    	Pageable pageable = new PageRequest(page, pageSize);
    	return orderService.findBySearchTermByStatus(term, status, pageable);
    }
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public Page<Orders> findPage(@RequestParam("page") int page, @RequestParam("pagesize") int pageSize) {
    	Pageable pageable = new PageRequest(page, pageSize, Sort.Direction.DESC, "id");
    	return orderService.findByPage(pageable);
    }
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @RequestMapping(value = "/pageandstatus", method = RequestMethod.GET)
    public Page<Orders> findPageByStatus(@RequestParam("page") int page, @RequestParam("pagesize") int pageSize, @RequestParam("status") int status) {
    	Pageable pageable = new PageRequest(page, pageSize, Sort.Direction.DESC, "id");
    	return orderService.findByPageByStatus(status, pageable);
    }
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value= "/{id}", method = RequestMethod.GET)
	public Orders findById(@PathVariable("id") Integer id) {
		Orders order = orderService.findById(id);
		return order;
	}
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value= "/status/{status}", method = RequestMethod.GET)
	public List<Orders> findByStatus(@PathVariable("status") Integer status) {
		List<Orders> order = orderService.findByStatus(status);
		return order;
	}
	@RequestMapping(method = RequestMethod.POST)
	public Orders addOrder(@RequestBody Orders order) {
		
		DetailOrder a = new DetailOrder(albumService.findByName("Black Eye"), 2);
		a.setOrder(order);
	    order.addDetails(a);
	    order.setCustomer(accountService.findOne(order.getCustomer().getUsername()));
		orderService.addOrder(order);
		return order;
	}
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value= "/cart", method = RequestMethod.GET)
	public List<Orders> findCart() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		List<Orders> list = orderService.findCartByUsername(authentication.getName());
		return list;
	}
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value= "/myorders", method = RequestMethod.GET)
	public List<Orders> findMyOrders() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		List<Orders> list = orderService.findOrdersByUsername(authentication.getName());
		return list;
	}
//	@RequestMapping(value= "/details/{id}", method = RequestMethod.DELETE)
//	public ResponseEntity<Void> removeDetailFromCart(@PathVariable("id") Integer id) {
//		detailOrderService.deleteDetail(id);
//		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
//	}
//	@RequestMapping(value= "/details", method = RequestMethod.POST)
//	public ResponseEntity<Void> addDetailToCart(@RequestBody DetailOrder detail) {
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		Orders cart = orderService.findCartByUsername(authentication.getName()).get(0);
//		
//		if(cart == null){
//			DetailOrder a = new DetailOrder(albumService.getAlbumById(detail.getAlbum().getId()), 2);
//			Orders order = new Orders();
//			a.setOrder(order);
//		    order.addDetails(a);
//		    order.setCustomer(accountService.findOne(authentication.getName()));
//			orderService.addOrder(order);
//		}else{
//			DetailOrder existDetail = detailOrderService.findByIdAlbum(cart.getId(),detail.getAlbum().getId());
//			if(existDetail == null) {
//				DetailOrder newDetails = new DetailOrder(albumService.getAlbumById(detail.getAlbum().getId()),cart, detail.getQuanlity());		
//				detailOrderService.addDetail(newDetails);
//			}else{
//				existDetail.setQuanlity(existDetail.getQuanlity() + detail.getQuanlity());
//				detailOrderService.addDetail(existDetail);
//			}
//
//		}
//		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
//	}
//	@RequestMapping(value="confirm", method = RequestMethod.PUT)
//	public void placeanorder() {
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		Orders cart = orderService.findCartByUsername(authentication.getName()).get(0);
//		orderService.book(cart.getId());
//	}
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@RequestMapping(value="/change", method = RequestMethod.PUT)
	public Orders change(@RequestParam("idOrder") int idOrder) {
		Orders order = orderService.findById(idOrder);
		order.setStatus(order.getStatus() + 1);
		if(order.getStatus() == 1){
		for (Iterator<DetailOrder> i = order.getDetails().iterator(); i.hasNext();) {
			DetailOrder item = i.next();
			albumService.reduceQuantity(item.getAlbum().getId(), item.getQuantity());
		}}
		return orderService.save(order);
//		orderService.book(cart.getId());
	}
}
