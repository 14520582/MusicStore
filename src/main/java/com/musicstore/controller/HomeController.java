package com.musicstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.musicstore.service.IAlbumService;


@Controller
@RequestMapping("/")
public class HomeController {
	@Autowired
	private IAlbumService albumService;
    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap model){
        return "customLogin";
    }
    @RequestMapping(value = "user", method = RequestMethod.GET)
    public String lo(ModelMap model){
        return "user-info";
    }
}