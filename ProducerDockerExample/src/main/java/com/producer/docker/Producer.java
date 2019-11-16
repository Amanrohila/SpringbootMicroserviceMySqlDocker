package com.producer.docker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Producer {

	private String TAG = Producer.class.getSimpleName();

	@GetMapping("docker/producer")
	public String hello() {

		return TAG + " : Hello I am producer";
	}

	@RequestMapping("/")
	public String defaultMethod() {
		return "Hi this is default docker producer application";
	}

}
