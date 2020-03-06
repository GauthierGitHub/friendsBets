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

import friendsbets.core.sb.models.Group;
import friendsbets.core.sb.services.GroupService;

@RestController
@CrossOrigin
@RequestMapping(value="/group", produces="application/json")
public class GroupController {

	@Autowired
	GroupService gs;

	@GetMapping("")
	public List<Group> findAll() {
		return gs.findAll();
	}

	@GetMapping("/{id}")
	public Group findById(@PathVariable int id) {
		return gs.findById(id);
	}

	@PostMapping("")
	public void save(@RequestBody Group e) {
		gs.save(e);
	}

	@PostMapping("/{id}")
	public void update(@RequestBody Group e, @PathVariable int id) {
		e.setId(id);
		gs.save(e);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		gs.delete(gs.findById(id));
	}
}
