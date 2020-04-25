package com.fm.app.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fm.app.entities.MenuVariant;
import com.fm.app.vo.MenuItemVO;

@RestController
@RequestMapping("api/menuItems")
@CrossOrigin
public class MenuItemController {

	@PostMapping
	public String save(MenuItemVO menuItemVO) {
		return "";
	}
	
	@GetMapping
	public List<MenuVariant> getAll() {
		return null;
	}
	
	@GetMapping("/{id}")
	public MenuVariant getOne() {
		return null;
	}
}