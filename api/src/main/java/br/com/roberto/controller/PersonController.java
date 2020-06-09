package br.com.roberto.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.roberto.data.vo.PersonVo;
import br.com.roberto.services.PersonServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


//@CrossOrigin
@Api(value = "Person Endpoint", tags = "Person Endpoint")
@RestController
@RequestMapping("/api/person/v1")
public class PersonController {
	

	@Autowired
	private PersonServices service;
////@CrossOrigin	
	@ApiOperation(value = "Busca todos as pessoas")
	@GetMapping()
	public List<PersonVo> fundByAll(@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "12") int limit,
			@RequestParam(value = "direction", defaultValue = "asc") String direction) {
		
		var sortDiretion = "desc".equalsIgnoreCase(direction) ? Direction.DESC : Direction.ASC;
		
		Pageable pageable = PageRequest.of(page, limit, Sort.by(sortDiretion, "id"));
		List<PersonVo> persons = service.findByAll(pageable);
		return persons;
		
	}
	
	@ApiOperation(value = "Deleta uma pessoa por id")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		service.delete(id);
		return ResponseEntity.ok().build();
	}
	
	@ApiOperation(value = "Busca uma pessoa por id")
	@GetMapping(value = "/{id}")
	public PersonVo fundById(@PathVariable("id") Long id) {		
		return service.findById(id);
	}

	@ApiOperation(value = "Cadastra uma pessoa por id")
	@PostMapping
	public PersonVo create(@RequestBody PersonVo person) {
		return service.create(person);
	}
	
	@ApiOperation(value = "Atualiza uma pessoa por id")
	@PutMapping
	public PersonVo update(@RequestBody PersonVo person) {
		return service.update(person);
	}
	
	@ApiOperation(value = "desabilita uma pessoa por id")
	@PatchMapping(value = "/{id}")
	public PersonVo disablePerson(@PathVariable("id") Long id) {		
		return service.disablePerson(id);
	}
	
	
	


}
