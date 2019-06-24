package com.htc.ea.graphqldemo;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import com.htc.ea.core.service.ConfigurationService;
import com.htc.ea.graphqldemo.domain.model.Author;
import com.htc.ea.graphqldemo.domain.model.User;
import com.htc.ea.graphqldemo.service.AuthorService;
import com.htc.ea.graphqldemo.service.UserService;

@SpringBootApplication
public class Application {
	
	private static final Logger logger = LoggerFactory.getLogger(Application.class);

	@Autowired
	private Environment env;
	@Autowired
	private ConfigurationService configurationService;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	ApplicationRunner init(UserService userService, AuthorService authorService) {
		String adry = env.getProperty("test.adry");
		String man = env.getProperty("test.man");
		System.out.println("test.adry = " + adry);
		System.out.println("test.man = " + man);
		
		String keyApp = "scheduled.task.execution.enabled";
		String keyListApp = "rules.process.exclude.changewindow";
		String valueApp = configurationService.getValue(keyApp);
		Set<String> valueListApp = configurationService.getValues(keyListApp);
		logger.info("scheduled.task.execution.enabled = {}", valueApp);		
		logger.info("rules.process.exclude.changewindow => Lista {}", Arrays.toString(valueListApp.toArray()));
		
		return args -> {
			Stream.of(
					"javadevjournal:Java Dev Journal", 
					"octocat:The Octocat", 
					"guest:From Another Universe"
			).forEach( data -> {
				User u = new User();
				String[] fields = data.split(":"); 
				u.setLogin(fields[0]);
				u.setName(fields[1]);
				userService.saveUser(u);
			});
			userService.getAllUsers().forEach(System.out::println);			
			Stream.of(
					"Lorenzo Lamas:Lorenzo Garabatero", 
					"Alejandro Cea:Thanos Panter", 
					"Osmaro Silva:El chief"
			).forEach( data -> {
				Author a = new Author();
				String[] fields = data.split(":"); 
				a.setName(fields[0]);
				a.setThumbnail(fields[1]);
				authorService.saveAuthor(a);
			});
			authorService.getAllAuthor().forEach(System.out::println);
		};
	}
}
