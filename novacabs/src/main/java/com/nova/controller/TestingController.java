package com.nova.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;

@RestController
@RequestMapping("/testing")
public class TestingController {
	
	@GetMapping("/demo")
	public String demo() {
		return "demo testing....... by prasanth";
	}

}
