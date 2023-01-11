package com.vts.redis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vts.redis.model.User;
import com.vts.redis.repository.UserRepo;

@RestController
public class UserController {
	
	@Autowired
	private UserRepo repo;
	
	@PostMapping("/user")
	public User save(@RequestBody User user) {
		return repo.save(user);
	}
	
	@GetMapping("/getall")
	public List<User> findAll(){
		return repo.findAll();
	}
	
	@GetMapping("{id}")
	public User getById(@PathVariable int  id) {
		return repo.getById(id);
	}
	
	@DeleteMapping("user/{id}")
	public boolean deleteById(@PathVariable int id) {
		repo.deleteById(id);
		return true;
		
	}
	
	}
	
	

