package br.com.epidemic.resource;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Size;

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

import br.com.epidemic.dto.CaseDTO;
import br.com.epidemic.entity.Case;
import br.com.epidemic.service.CaseService;
import lombok.Data;

@RestController
@RequestMapping("/api/case")
public class CaseResource {

	@Autowired
	private CaseService service;
	
	@GetMapping
	public ResponseEntity<List<Case>> get(){
		List<Case> cases = service.findAll();
		return ResponseEntity.ok(cases);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Case> get(@PathVariable("id") long id){
		Case case1 = service.findById(id);
		return ResponseEntity.ok(case1);
	}
	
	@GetMapping(path = "/getByEpidemicId/{id}")
	public ResponseEntity<List<Case>> getByEpidemicId(@PathVariable("id") long id){
		List<Case> cases = service.findByEpidemicId(id);
		return ResponseEntity.ok(cases);
	}
	
	@PostMapping(path = "/getByArea")
	public ResponseEntity<List<Case>> getByArea(@Valid @RequestBody Area area){
		List<Case> cases = service.findByArea(area.getLatitude(), area.getLongitude());
		return ResponseEntity.ok(cases);
	}
	
	@PostMapping(path = "/getByArea/{id}")
	public ResponseEntity<List<Case>> getByArea(@Valid @RequestBody Area area, @PathVariable("id") long id){
		List<Case> cases = service.findByAreaEpidemic(area.getLatitude(), area.getLongitude(), id);
		return ResponseEntity.ok(cases);
	}
	
	@PostMapping
	public ResponseEntity<Case> post(@Valid @RequestBody CaseDTO dto){
		Case case1 = dto.toEntity();
		case1 = service.save(case1);
		return ResponseEntity.ok(case1);
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<Case> put(@Valid @RequestBody CaseDTO dto, @PathVariable("id") long id){
		Case case1 = dto.toEntity();
		case1.setId(id);
		case1 = service.update(case1);
		return ResponseEntity.ok(case1);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") long id){
		service.delete(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@Data
	static class Area{
		
		@Size(max = 2,min = 2, message = "Informe latitude corretamente!!")
		private double[] latitude;
		@Size(max = 2,min = 2, message = "Informe longitude corretamente!!")
		private double[] longitude;
	}
}
