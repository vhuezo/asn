package com.htc.ea.graphqldemo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.htc.ea.graphqldemo.domain.model.User;
import com.htc.ea.graphqldemo.domain.repository.UserRepository;

@Service 
public class UserService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	
	private UserRepository store ;
	
	public UserService(UserRepository db) {
		this.store = db ;
	}
	
	public List<User> getAllUsers() {
		return this.store.findAll();
	}
	
	public Optional<User> getUser(int id) {
		return this.store.findById(id);
	}
	
	public List<User> getUsers(int first, int last) {
		if ((last == 0) || (last < first)) {
			// Ignore last if invalid value was specified
			last = (int) this.store.count();
		}
		return this.store.findAllById(
			IntStream.rangeClosed(first, last)
			.boxed()
			.collect(Collectors.toList())
		);
	}
	
	@Transactional
	public User newUser(String login, String name) {
		User u = new User();
		u.setLogin(login);
		u.setName(name);
		return this.store.save(u);
	}
	
	public User saveUser(User user) {
		return this.store.save(user);
	}
	
	@Transactional
	public Boolean deleteUser(Integer id) {
		Boolean result;
		try {
			this.store.deleteById(id);
			result = true;
		} catch (Exception e) {
			result = false;
			logger.error("Error al eliminar usuario", e);
		}
		return result;
	}
}