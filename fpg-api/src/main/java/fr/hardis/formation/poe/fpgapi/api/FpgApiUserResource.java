package fr.hardis.formation.poe.fpgapi.api;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.h2.util.New;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import fr.hardis.formation.poe.fpgapi.model.User;
import fr.hardis.formation.poe.fpgapi.service.UserService;

@RestController
@RequestMapping("/api")
public class FpgApiUserResource {

	private final Logger log = LoggerFactory.getLogger(FpgApiUserResource.class);

	@Autowired
	UserService userService;

	/**
	 * Hello world resource
	 */
	// @RequestMapping(value = "/hello/{login}", method = RequestMethod.GET,
	// produces = MediaType.APPLICATION_JSON_VALUE)
	// public ResponseEntity<User> deleteUser(@PathVariable String login) {
	// log.debug("REST request to hello : {}", login);
	// User user = new User();
	// user.setName(login);
	// return ResponseEntity.ok().body(user);
	// }

	@RequestMapping(value = "/users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> getList() {
		log.info("REST request to hello : {}", "getList");
		List<User> users = userService.getListUsers();
		return ResponseEntity.ok().body(users);
	}
	
	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Optional<User>> getById(@PathVariable Long id) {
		log.info("REST request to hello : {}", "getById");
		Optional<User> user = userService.getUser(id);
		return ResponseEntity.ok().body(user);
	}

	
	
	 @RequestMapping(value = "/users/add",method = RequestMethod.GET)
	 public ResponseEntity add(@RequestParam Long id, @RequestParam String name, @RequestParam String email, @RequestParam String mDP , @RequestParam String firstName) throws Exception {
		 
//		 if(!mDP.equals(mDPV))
//			 return new ResponseEntity<ErrorMessage>(new ErrorMessage("Mot de passe different"), HttpStatus.CONFLICT);
		User user;
		if (id!=0) {
			Optional<User> temp=userService.getUser(id);
			user=temp.get();
			log.info("User ecuperer avec update : {}", user.toString());
		}else
			user = new User();
		
		user.setEmail(email);
		user.setName(name);
		user.setMotDePasse(mDP);
		user.setFirstName(firstName);

		if (id!=0) {
			userService.updateUser(user);
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
			
		log.info("REST request to user created : {}", user.toString());

		userService.addUser(user);
		return new ResponseEntity<User>(user, HttpStatus.OK);
		
	 }
	 
	 @RequestMapping(value="/users/remove",method = RequestMethod.GET)
	 public ResponseEntity<List<User>> remove(@RequestParam Long id){
		 userService.deleteUserById(id);
		 List<User> users = userService.getListUsers();
		 log.info("REST request to user remove: {}", id);
		 return ResponseEntity.ok().body(users);
	 }
	
//
//	@RequestMapping(value = "/users", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<Void> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {
//		System.out.println("Creating User " + user.getName());
//
//		if (userService.isUserExist(user)) {
//			System.out.println("A User with name " + user.getName() + " already exist");
//			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//		}
//
//		userService.addUser(user);
//
//		HttpHeaders headers = new HttpHeaders();
//		headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
//		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
//	}

	// @RequestMapping(value = "/users", method = RequestMethod.POST, produces =
	// MediaType.APPLICATION_JSON_VALUE)
	// public ResponseEntity<?> createUser(@RequestBody ManagedUserDTO
	// managedUserDTO, HttpServletRequest request)
	// throws URISyntaxException {
	// log.debug("REST request to save User : {}", managedUserDTO);
	// if (userService.findOneByLogin(managedUserDTO.getLogin()).isPresent()) {
	// return ResponseEntity.badRequest().body("Login already in use");
	// } else if (userService.findOneByEmail(managedUserDTO.getEmail()).isPresent())
	// {
	// return ResponseEntity.badRequest().body("Email already in use");
	// } else {
	// User newUser = userService.createUser(managedUserDTO);
	// String baseUrl = request.getScheme() + // "http"
	// "://" + // "://"
	// request.getServerName() + // "myhost"
	// ":" + // ":"
	// request.getServerPort() + // "80"
	// request.getContextPath(); // "/myContextPath" or "" if deployed in root
	// context
	// mailService.sendCreationEmail(newUser, baseUrl);
	// return ResponseEntity.created(new URI("/api/users/" +
	// newUser.getLogin())).body(newUser);
	// }
	// }

//	 @RequestMapping(value = "/test", method = RequestMethod.POST)
//	 public ResponseEntity<User> update(@RequestBody User user) {
//	
//	 if (user != null) {
//	 user.setAge(user.getAge() + 1);
//	 }
//	
//	 // TODO: call persistence layer to update
//	 return new ResponseEntity<User>(user, HttpStatus.OK);
//	 }
	// @RequestMapping(value = "/user", method = RequestMethod.POST)
	// public ResponseEntity<Void> createUser(@RequestBody User user,
	// UriComponentsBuilder ucBuilder) {
	// System.out.println("Creating User " + user.getName());
	//
	// if (userService.isUserExist(user)) {
	// System.out.println("A User with name " + user.getName() + " already exist");
	// return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	// }
	//
	// userService.addUser(user);
	//
	// HttpHeaders headers = new HttpHeaders();
	// headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
	// return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	// }
	//
}
