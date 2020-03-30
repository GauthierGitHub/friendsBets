package friendsbets.ws.controllers;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import friendsbets.core.sb.models.User;
import friendsbets.core.sb.services.AuthenticationService;
import friendsbets.core.sb.services.UserService;

@RestController
@CrossOrigin
@RequestMapping("/authentication")
public class AuthenticationController {

	@Autowired
	private AuthenticationService as;
	
	@Autowired
	private UserService us;

	@PostMapping("/register")
	public User register(@RequestBody User u) {
		return as.register(u);
	}
	
	@PostMapping("/login")
	public User login(@RequestParam String email, @RequestParam String password) {
		return as.login(email, password);
	}

	@PutMapping("update")
	public void update(@RequestBody User u) {
		as.update(u);
	}

	@DeleteMapping("/{id}")
//	@RolesAllowed({"Administrator"}) ?
	public void delete(@PathVariable int id) {
		as.delete(us.findById(id));
	}
	
//	@GetMapping("/logout") public void logout(@RequestParam String email) { 
//		as.logout(email); // TODO: must get connected Users from the request 	
//	}
//	
//	@PostMapping("/byToken") public void byToken(@RequestParam String token) {
//		 as.findByToken(token, Duration.ofMinutes(30), true);
//	}

	
	
	
	
	
//	@Autowired
//	private Environment env;
	
//	@RequestMapping(value="/login", method = {RequestMethod.OPTIONS, RequestMethod.GET, RequestMethod.POST}, produces = "application/json")


//	@RequestMapping(value="/signin", method=RequestMethod.OPTIONS, produces = "application/json")
//	public User signin(@RequestParam String email, @RequestParam String password) {
//	public User signin(@RequestBody String email, @RequestBody String password) {
//		Logger.getLogger(getClass()).info("Signin running");
//		return ms.signIn(email, password);
//	}

	// TODO: picture !
//	@PostMapping("signup")
//	public void signup(@RequestPart User m, @RequestPart(name="image", required=false) MultipartFile image) throws IOException {
//		// saving image
//		if (image!=null && !image.isEmpty()) {
//			String imagePath = "User-" + m.getAlias()
//					+ image.getOriginalFilename().substring(image.getOriginalFilename().lastIndexOf('.'));
//			Files.copy(image.getInputStream(), Paths.get(env.getProperty("graze.images.path") + imagePath),
//					StandardCopyOption.REPLACE_EXISTING);
//			m.setImage(imagePath);
//		}
//		// saving User
//		ms.save(m);
//	}

}
