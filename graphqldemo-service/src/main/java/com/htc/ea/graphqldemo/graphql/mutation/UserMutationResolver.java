package com.htc.ea.graphqldemo.graphql.mutation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.htc.ea.graphqldemo.domain.model.User;
import com.htc.ea.graphqldemo.service.UserService;

@Component
public class UserMutationResolver implements GraphQLMutationResolver {
	
	private static final Logger logger = LoggerFactory.getLogger(UserMutationResolver.class);
	
	@Autowired
	private UserService userService;

	public User createUser(String login, String name) {
		User user = this.userService.newUser(login, name);
		logger.info("Usuario {}, {}", (user!=null ? "creado exitosamente " : ", hubo un error en la creación"), "login: " + login + ", name: " + name);
		return user;
	}
	
	public Boolean deleteUser(int id) {
		Boolean delete = this.userService.deleteUser(id);
		logger.info("Usuario: {}, {}, ", id, (delete ? "eliminado exitosamente!" : "hubo un error en la eliminación!"));
		return delete;
	}
}