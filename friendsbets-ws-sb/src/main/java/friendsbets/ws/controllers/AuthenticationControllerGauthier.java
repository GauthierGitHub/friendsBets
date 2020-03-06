package friendsbets.ws.controllers;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import friendsbets.core.sb.models.User;
import friendsbets.core.sb.services.UserService;

@RestController
@CrossOrigin
@RequestMapping("/authentication")
public class AuthenticationControllerGauthier {

	@Autowired
	private UserService ms;
//	@Autowired
//	private Environment env;

//	@RequestMapping(value="/signin", method=RequestMethod.OPTIONS, produces = "application/json")
//	public User signin(@RequestParam String email, @RequestParam String password) {
////	public User signin(@RequestBody String email, @RequestBody String password) {
//		Logger.getLogger(getClass()).info("Signin running");
//		return ms.signIn(email, password);
//	}

	/*
	 * @RequestMapping(value="/signin", method=RequestMethod.POST, produces =
	 * "application/json") public User signin(@RequestParam String
	 * email, @RequestParam String password) { // public User signin(@RequestBody
	 * String email, @RequestBody String password) {
	 * Logger.getLogger(getClass()).info("Signin running"); return ms.signIn(email,
	 * password); }
	 * 
	 * @GetMapping("/signout") public void signout(@RequestParam String email) { //
	 * ms.signOut(email); // TODO: must get connected Users from the request }
	 * 
	 * @PostMapping("/byToken") public void byToken(@RequestParam String token) {
	 * ms.findByToken(token, Duration.ofMinutes(30), true); }
	 */

	// without pics
	@PostMapping("/signup")
	public void signup(@RequestBody User m) {
		ms.save(m);
	}

	// TODO: make it works !
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
