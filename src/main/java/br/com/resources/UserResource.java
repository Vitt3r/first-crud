package br.com.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.entities.User;
import br.com.entities.DTOs.UserDTO;
import br.com.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	UserService service;
	
	@GetMapping
	public ResponseEntity<List<User>> listAll(){
		return ResponseEntity.ok().body(service.listAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		return ResponseEntity.ok().body(service.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<User> create(@RequestBody User user){
		user = service.create(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).body(user);
	}
	
	@PutMapping(value = "/name/{id}")
	public ResponseEntity<User> updateName(@RequestBody UserDTO user, @PathVariable Long id){
		return ResponseEntity.ok().body(service.updateName(user, id));
	}
	
	@PutMapping(value = "/email/{id}")
	public ResponseEntity<User> updateEmail(@RequestBody UserDTO user, @PathVariable Long id){
		return ResponseEntity.ok().body(service.updateEmail(user, id));
	}
	
	@PutMapping(value = "/height/{id}")
	public ResponseEntity<User> updateHeight(@RequestBody UserDTO user, @PathVariable Long id){
		return ResponseEntity.ok().body(service.updateHeight(user, id));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
