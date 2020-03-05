package friendsbets.ws.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import graze.models.Event;
import graze.services.EventService;

@RestController
@RequestMapping("event")
@CrossOrigin
public class EventsControllerGauthier {

	@Autowired
	EventService es;
	
	@GetMapping("")
	public List<Event> findAll() {
		return es.findAll();
	}
	
	@GetMapping("/{id}")
	public Event findById(@PathVariable int id) {
		return es.findById(id);
	}
	
	@PostMapping("")
	public void save(@RequestBody Event e) {
		es.save(e);
	}
	
	@PostMapping("/{id}")
	public void update(@RequestBody Event e, @PathVariable int id) {
		e.setId(id);
		es.save(e);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		es.delete(es.findById(id));
	}
}
