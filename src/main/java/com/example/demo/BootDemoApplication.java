package com.example.demo;

import com.example.demo.entity.Skill;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class BootDemoApplication {
	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(BootDemoApplication.class, args);
	}

	@PostConstruct
	public void setupDbWithData() {
		User user1 = new User("Ashish", null);
		user1.setSkills(Arrays.asList(new Skill("java"), new Skill("js")));
//		userRepository.save(user);

		User user2 = new User("Hajo", Arrays.asList(new Skill("Pact"), new Skill("Watching Cat Videos")));
//		userRepository.save(user);

		userRepository.saveAll(List.of(user1, user2));
	}
}
