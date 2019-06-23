package br.com.epidemic.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.epidemic.dto.UserDTO;
import br.com.epidemic.entity.User;
import br.com.epidemic.service.UserService;

@RestController
@RequestMapping("api/user")
public class UserResource {
	
	@Autowired
	private UserService service;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@GetMapping
	public ResponseEntity<List<User>> get(){
		List<User> users = service.findAll();
		return ResponseEntity.ok(users);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<User> get(@PathVariable("id") long id){
		User u = service.findById(id);
		return ResponseEntity.ok(u);
	}
	
	@PostMapping
	public ResponseEntity<User> post(@Valid @RequestBody UserDTO dto){
		dto.setPassword(bCryptPasswordEncoder.encode(dto.getPassword()));
		User u = dto.toEntity();
		u = service.save(u);
		return ResponseEntity.ok(u);
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<User> put(@Valid @RequestBody UserDTO dto, @PathVariable("id") long id){
		User u = dto.toEntity();
		u.setId(id);
		u = service.update(u);
		return ResponseEntity.ok(u);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") long id){
		service.delete(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
