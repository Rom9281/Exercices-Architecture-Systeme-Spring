package com.sp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sp.model.User;
import com.sp.service.UserService;

@RestController
public class UserRestCrt {
	@Autowired
	UserService uService;

	@RequestMapping(method = RequestMethod.POST, value = "/user")
	public void addUser(@RequestBody User user) {
		uService.addUser(user);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/user")
	public Iterable<User> getAllUser() {
		Iterable<User> ulist = uService.getAllUser();
		return ulist;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/user/{id}")
	public User getUser(@PathVariable String id) {
		User u = uService.getUser(Integer.valueOf(id));
		return u;
	}
	/**
	 * Requete pour generer les cartes lors de la création d'un utilisateur
	 * @PARAM User user
	 * @RETURN Integer Id
	 * */
	@RequestMapping(method = RequestMethod.GET, value = "/createUser")
	public User getUser(@RequestParam Integer id) {
		User u = uService.getUser(Integer.valueOf(id));
		return u;
	}
}
