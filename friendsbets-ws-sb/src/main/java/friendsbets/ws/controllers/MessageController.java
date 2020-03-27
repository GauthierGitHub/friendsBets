package friendsbets.ws.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIdentityReference;

import friendsbets.core.sb.models.Message;
import friendsbets.core.sb.services.MessageService;

@RestController
@RequestMapping("/message")
public class MessageController {
	
	@Autowired
	MessageService ms;

	/**
	 * Find twenty last messages for a group.
	 * Automatically sorted by incremental id so sorted by date too.
	 * Json produced with just id for groups  ( @JsonIdentity + @JsonIdentityReference ).
	 * First user is POJO and rest is just id.
	 * TODO: sort by date ? 
	 * @param id
	 * @return List<Message> 
	 */
	@GetMapping("/{id}")
	public List<Message> findTwenty(@PathVariable String id){
		return ms.findTwenty(id, 0);
	}
	
	/**
	 * Find twenty last messages for a group with an offset.
	 * Automatically sorted by incremental id so sorted by date too.
	 * Json produced with just id for groups  ( @JsonIdentity + @JsonIdentityReference ).
	 * First user is POJO and rest is just id.
	 * TODO: sort by date ? 
	 * @param id
	 * @param offset
	 * @return
	 */
	@GetMapping("/{id}/{offset}")
	public List<Message> findTwenty(@PathVariable String id, @PathVariable String offset){
		return ms.findTwenty(id, Integer.parseInt(offset));
	}
	
	@PostMapping("")
	public void save(@RequestBody Message m) {
		ms.save(m);
	}

}
