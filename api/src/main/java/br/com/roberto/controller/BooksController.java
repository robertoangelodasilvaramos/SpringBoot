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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.roberto.data.vo.BooksVo;
import br.com.roberto.services.BooksService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Books Endpoint", tags = "Books Endpoint")
@RestController
@RequestMapping("/api/books/v1")
public class BooksController {

	@Autowired
	private BooksService service;

	@ApiOperation(value = "Busca todos os livros")
	@GetMapping
	public List<BooksVo> fundByAll(@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "12") int limit,
			@RequestParam(value = "direction", defaultValue = "asc") String direction) {
		
		var sortDiretion = "desc".equalsIgnoreCase(direction) ? Direction.DESC : Direction.ASC;

		Pageable pageable = PageRequest.of(page, limit, Sort.by(sortDiretion, "id"));
		List<BooksVo> books = service.findByAll(pageable);
		return books;
	}

	@ApiOperation(value = "Deleta um livro por id")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		service.delete(id);
		return ResponseEntity.ok().build();
	}

	@ApiOperation(value = "Busca um livro por id")
	@GetMapping(value = "/{id}")
	public BooksVo fundById(@PathVariable("id") Long id) {
		return service.findById(id);
	}

	@ApiOperation(value = "Cadastra um livro por id")
	@PostMapping()
	public BooksVo create(@RequestBody BooksVo books) {
		return service.create(books);
	}

	@ApiOperation(value = "Atualiza um livro por id")
	@PutMapping
	public BooksVo update(@RequestBody BooksVo books) {
		return service.update(books);
	}

}
