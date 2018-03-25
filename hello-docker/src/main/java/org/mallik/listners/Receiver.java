package org.mallik.listners;

import org.mallik.entity.Users;
import org.mallik.repo.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

	@Autowired
	private UsersRepository usersRepository;
	
    @JmsListener(destination = "users.queue",containerFactory="myFactory")
    public void receiveMessage(Users users) {
        System.out.println("Received <" + users + ">");
        usersRepository.save(users);
    }

}