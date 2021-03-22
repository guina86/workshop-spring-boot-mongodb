package com.ginkei.workshopmongo.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.ginkei.workshopmongo.domain.User;
import com.ginkei.workshopmongo.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
			
		repository.deleteAll();
		
		var maria = new User(null, "Maria Brown", "maria@gmail.com");
		var alex = new User(null, "Alex Green", "alex@gmail.com");
		var bob = new User(null, "bob Grey", "bob@gmail.com");
		
		repository.saveAll(List.of(maria, alex, bob));
		
	}

}
