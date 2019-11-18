package com.consumer.docker;

import java.io.IOException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Consumer {

	private String TAG = Consumer.class.getSimpleName();

	@GetMapping("docker/consumer")
	public String hello() {

//		String baseUrl = "http://localhost:8088/docker/producer";
		String baseUrl = "http://producer:8088/docker/producer";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = null;
		try {
			response = restTemplate.exchange(baseUrl, HttpMethod.GET, getHeaders(), String.class);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		System.out.println(response.getBody());

		return TAG + " : Hello consumer  response from producer is   " + response.getBody();
	}

	@RequestMapping("/")
	public String defaultMethod() {
		return "Hi this is default docker consumer application";
	}

@GetMapping("docker/users")
	public String all() {
		String baseUrl = "http://producer:8088/docker/users";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = null;
		try {
			response = restTemplate.exchange(baseUrl, HttpMethod.GET, getHeaders(), String.class);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		System.out.println(response.getBody());

		return TAG + " :  " + response.getBody().toString();
	}

	private static HttpEntity<?> getHeaders() throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<>(headers);
	}

}
