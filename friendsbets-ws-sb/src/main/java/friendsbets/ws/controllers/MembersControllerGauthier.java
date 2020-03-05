package friendsbets.ws.controllers;

import java.util.List;

import org.jboss.logging.Logger;
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

import graze.models.Member;
import graze.services.MemberService;

@RestController
@RequestMapping("/member")
@CrossOrigin // not needed, declared for all in Webappconfig
public class MembersControllerGauthier {

	@Autowired
	MemberService ms;
	
	@GetMapping("")
	public List<Member> findAll() {
		System.out.println("membersController findAll");
		return ms.findAll();
	}
	
	@GetMapping("/{id}")
	public Member findById(@PathVariable int id) {
		return ms.findById(id);
	}
	
	/**
	 * 
	 *     {"jsonType": "Member",
		    "id": 39,
		    "alias": "aa",
		    "image": "undefinedimageUrl",
		    "password": "aa",
		    "email": "aa",
		    "token": null,
		    "tokenLastUsed": null}
	 * @param m
	 */
	@PostMapping("")
	public void save(@RequestBody Member m) {
		ms.save(m);
	}
	
	@PutMapping("/{id}")
	public void update(@PathVariable int id, @RequestBody Member m) {
		m.setId(id);
		ms.update(m);
	}
	
	@DeleteMapping("/{id}")
//	@RolesAllowed({"Administrator"})
	public void delete(@PathVariable int id) {
		ms.delete(ms.findById(id));
	}

	@GetMapping({"/search", "/search/{pattern}"})
	public List<Member> findByAliasOrEmailLike(@PathVariable(name="pattern", required=false) String pattern) {
//		Logger.getLogger(getClass()).info("//////////!!! search = " + pattern);
		return ms.findByAliasOrEmailLike(pattern == null ? "" : pattern);
	}
}
