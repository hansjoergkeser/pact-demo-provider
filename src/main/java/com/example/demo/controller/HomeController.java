package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class HomeController {

	@RequestMapping("/home")
	public String home() {
		log.info("Incoming request to /home");
		return "index";
	}

}
