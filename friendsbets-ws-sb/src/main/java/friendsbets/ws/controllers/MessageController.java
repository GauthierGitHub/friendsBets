package friendsbets.ws.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import friendsbets.core.sb.models.Message;
import friendsbets.core.sb.services.MessageService;

@RestController
@RequestMapping("/message")
public class MessageController {
	
	@Autowired
	MessageService ms;
	
	@PostMapping("")
	public void save(@RequestBody Message m) {
		System.out.println(m.getId());
		System.out.println("===== Author =====");
		System.out.println(m.getAuthor().getId());
		System.out.println(m.getAuthor().getNickname());
		System.out.println("===== Group =====");
		System.out.println(m.getGroup().getId());
		System.out.println(m.getGroup().getName());
		System.out.println("===== Content =====");
		System.out.println(m.getContent());
		System.out.println("===== Date =====");
		System.out.println(m.getDate());
		ms.save(m);
	}
}
