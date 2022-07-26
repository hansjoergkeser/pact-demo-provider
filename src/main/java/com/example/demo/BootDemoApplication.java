package com.example.demo;

import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootDemoApplication {
	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(BootDemoApplication.class, args);
	}

//	@PostConstruct
//	public void setupDbWithData() {
//		User user = new User("Hajo", Arrays.asList(new Skill("Pact"), new Skill("Watching Cat Videos")));
//		userRepository.save(user);
//		userRepository.saveAll(List.of(user));
//	}
}
