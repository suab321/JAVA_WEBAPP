package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Entity.Chat;
import com.example.Entity.User;
import com.example.Repository.ChatRepository;
import com.example.Repository.UserRepository;

@RestController
public class Controller {
	@Autowired
	private UserRepository ur;
	@Autowired
	private ChatRepository cr;

	@PostMapping("/addUser")
	public boolean addUser(@RequestBody User user) {
		ur.save(user);
		return true;
	}
	@PostMapping("/message")
	public boolean message(@RequestBody Chat message) {
		System.out.println(message.getFromUser()+" "+message.getToUser());
		cr.save(message);
		return true;
	}
	@GetMapping("/getMessage")
	public List<Chat> getMessages(@RequestParam int to,@RequestParam int from){
		return cr.getMessages(from, to);
	}
}
