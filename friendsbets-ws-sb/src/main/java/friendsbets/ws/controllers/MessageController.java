package friendsbets.ws.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	@GetMapping("/{id}")
	public List<Message> findTwenty(@PathVariable String id){
		return ms.findTwenty(id, 0);
	}
	
	@GetMapping("/{id}/{offset}")
	public List<Message> findTwenty(@PathVariable String id, @PathVariable String offset){
		return ms.findTwenty(id, Integer.parseInt(offset));
	}
	
	@PostMapping("")
	public void save(@RequestBody Message m) {
		ms.save(m);
	}
}
