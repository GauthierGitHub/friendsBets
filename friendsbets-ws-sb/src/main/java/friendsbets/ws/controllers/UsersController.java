package friendsbets.ws.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import friendsbets.core.sb.models.User;
import friendsbets.core.sb.services.UserService;

@RestController
@CrossOrigin // not needed, declared for all in Webappconfig
@RequestMapping("/user")
public class UsersController {

	@Autowired
	UserService ms;

	@GetMapping("")
	public List<User> findAll() {
		System.out.println("UsersController findAll");
		return ms.findAll();
	}

	@GetMapping("/{id}")
	public User findById(@PathVariable int id) {
		return ms.findById(id);
	}

	/**
	 * 
	 * {"jsonType": "User", "id": 39, "alias": "aa", "image": "undefinedimageUrl",
	 * "password": "aa", "email": "aa", "token": null, "tokenLastUsed": null}
	 * 
	 * @param m
	 */
	@PostMapping("")
	public void save(@RequestBody User m) {
		ms.save(m);
	}

	@PutMapping("/{id}")
	public void update(@PathVariable int id, @RequestBody User m) {
		m.setId(id);
		ms.update(m);
	}

	@DeleteMapping("/{id}")
//	@RolesAllowed({"Administrator"})
	public void delete(@PathVariable int id) {
		ms.delete(ms.findById(id));
	}

	@GetMapping({ "/search", "/search/{pattern}" })
	public Set<User> findByAliasOrEmailLike(@PathVariable(name = "pattern", required = false) String pattern) {
//		Logger.getLogger(getClass()).info("//////////!!! search = " + pattern);
		return ms.findByNicknameOrEmailLike(pattern == null ? "" : pattern);
	}
	
	@GetMapping("/friends/{id}")
	public List<User> findAllOthers(@PathVariable int id) {
		return ms.findAllOthers(id);
	}
}
