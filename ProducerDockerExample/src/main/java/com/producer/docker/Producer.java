package com.producer.docker;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Producer {

	private String TAG = Producer.class.getSimpleName();

	@Autowired
	private UserProducerRepository usersRepository;

	@GetMapping("docker/producer")
	public String hello() {

		return TAG + " : Hello I am producer";
	}

	@RequestMapping("/")
	public String defaultMethod() {
		return "Hi this is default docker producer application";
	}

	@GetMapping("docker/users")
	public String all() {
		System.out.print("getting data from db  ");
		System.out.println(usersRepository.findAll().toString());
		return usersRepository.findAll().toString();
	}
 

	@GetMapping("/create")
	public List<Users> users() {
		Users users = new Users();
		users.setId(1);
		users.setName("Sam");
		users.setSalary(3400);
		users.setTeamName("Development");

		usersRepository.save(users);

		return usersRepository.findAll();
	}

}
