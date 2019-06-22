package br.com.epidemic.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.epidemic.dto.EpidemicDTO;
import br.com.epidemic.entity.Epidemic;
import br.com.epidemic.service.EpidemicService;

@RestController
@RequestMapping("api/epidemic")
public class EpidemicResource {
	
	@Autowired
	private EpidemicService service;
	
	@GetMapping
	public ResponseEntity<List<Epidemic>> get(){
		List<Epidemic> Epidemics = service.findAll();
		return ResponseEntity.ok(Epidemics);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Epidemic> get(@PathVariable("id") long id){
		Epidemic ep = service.findById(id);
		return ResponseEntity.ok(ep);
	}
	
	@PostMapping
	public ResponseEntity<Epidemic> post(@Valid @RequestBody EpidemicDTO dto){
		Epidemic ep = dto.toEntity();
		ep = service.save(ep);
		return ResponseEntity.ok(ep);
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<Epidemic> put(@Valid @RequestBody EpidemicDTO dto, @PathVariable("id") long id){
		Epidemic ep = dto.toEntity();
		ep.setId(id);
		ep = service.update(ep);
		return ResponseEntity.ok(ep);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") long id){
		service.delete(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
