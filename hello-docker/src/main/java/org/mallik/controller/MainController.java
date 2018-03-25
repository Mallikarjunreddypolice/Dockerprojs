package org.mallik.controller;

import org.mallik.entity.Users;
import org.mallik.repo.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MainController {

	@Autowired
	private UsersRepository usersRepository;

	@GetMapping(path = "/hello")
	public String home() {
		return "Hello kube my host is ::"+System.getenv("HOSTNAME");
	}

	@Autowired
	  private JmsTemplate jmsTemplate;

	@GetMapping(path = "/add") 
	public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String team) {

		Users n = new Users();
		n.setName(name);
		n.setTeam(team);
		
        System.out.println("Sending an email message.");
        jmsTemplate.convertAndSend("users.queue", n);
		return "message sent to queue";
	}

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Users> getAllUsers() {

		return usersRepository.findAll();
	}

}