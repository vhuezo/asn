package com.htc.ea.graphqldemo.graphql.query;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.htc.ea.graphqldemo.domain.model.User;
import com.htc.ea.graphqldemo.service.UserService;

@Component
public class UserQueryResolver implements GraphQLQueryResolver {
	
	private static final Logger logger = LoggerFactory.getLogger(UserQueryResolver.class);
	
	private UserService userService ;
	
	public UserQueryResolver(UserService userService) {
		this.userService = userService;
	}
	
	public List<User> users(int first, int last) {
		logger.info("Query: [" + first + "] to [" + last + "]");
		if((first == 0) && (last == 0)) {
			return this.userService.getAllUsers();
		} else {
			return this.userService.getUsers(first, last);
		}
	}
	
	public Optional<User> user(int id) {
		return this.userService.getUser(id);
	}
}