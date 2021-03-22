package com.ginkei.workshopmongo.config;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.ginkei.workshopmongo.domain.Post;
import com.ginkei.workshopmongo.domain.User;
import com.ginkei.workshopmongo.dto.AuthorDTO;
import com.ginkei.workshopmongo.repositories.PostRepository;
import com.ginkei.workshopmongo.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
			
	
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		var maria = new User(null, "Maria Brown", "maria@gmail.com");
		var alex = new User(null, "Alex Green", "alex@gmail.com");
		var bob = new User(null, "bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(List.of(maria, alex, bob));
		
		var post1 = new Post(null, Instant.parse("2019-03-21T19:53:07Z"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
		var post2 = new Post(null, Instant.parse("2019-03-23T21:13:00Z"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));
		
		postRepository.saveAll(List.of(post1, post2));
		
		maria.getPosts().addAll(List.of(post1, post2));
		
		userRepository.save(maria);
		
	}

}
