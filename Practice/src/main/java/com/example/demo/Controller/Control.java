package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.UserEntity;
import com.example.demo.Repository.Repo;

@RestController
public class Control {
	@Autowired
	public Repo rep;
	
	@GetMapping("/getall")
	public List<UserEntity> getall() {
		return rep.findAll();
		
	}
	@PostMapping("/add")
	public UserEntity addinfo(@RequestBody UserEntity user) {
		rep.save(user);
		return user;
	}
	@PutMapping("/update")
	public UserEntity updateuser (@RequestBody UserEntity upto) {
		try {
			rep.save(upto);
			return upto;
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return upto;
	}
	
@DeleteMapping("/getdel/{Id}")
public String del(@PathVariable int Id) {
	try {
	@SuppressWarnings("deprecation")
	UserEntity upto=rep.getOne(Id);
	rep.delete(upto);
	return "delete";
}
catch(Exception ex) {
	ex.printStackTrace();
	
}
	return null;
	
}
}
