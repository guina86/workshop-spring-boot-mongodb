package com.ginkei.workshopmongo.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ginkei.workshopmongo.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		var maria = new User("1", "Maria Silve", "maria@gmail.com");
		var alex = new User("2", "Alex Green", "alex@gmail.com");
		var list = List.of(maria, alex);
		return ResponseEntity.ok(list);
	}
	

}
