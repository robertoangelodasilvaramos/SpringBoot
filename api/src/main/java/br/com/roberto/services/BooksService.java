package br.com.roberto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.roberto.converter.custom.BooksConverter;
import br.com.roberto.converts.DozerConverter;
import br.com.roberto.data.model.Books;
import br.com.roberto.data.vo.BooksVo;
import br.com.roberto.exception.ResourceNotFoundException;
import br.com.roberto.repository.BooksRepository;

@Service
public class BooksService {

	@Autowired
	BooksRepository repository;

	@Autowired
	BooksConverter converter;

	public BooksVo findById(Long id) {
		var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No resords for this ID"));

		return DozerConverter.parseObjet(entity, BooksVo.class);
	}

	public List<BooksVo> findByAll(Pageable pageable) {
		
		var entities = repository.findAll(pageable).getContent();
		return DozerConverter.parseListObjets(entities, BooksVo.class);
	}

	public BooksVo create(BooksVo books) {
		Books entity = DozerConverter.parseObjet(books, Books.class);
		var vo = DozerConverter.parseObjet(repository.save(entity), BooksVo.class);
		return vo;
	}

	public BooksVo update(BooksVo books) {
		var entity = repository.findById(books.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No resords for this ID"));
		entity.setAuthor(books.getAuthor());
		entity.setLaunchDate(books.getLaunchDate());
		entity.setPrice(books.getPrice());
		entity.setTitle(books.getTitle());
		var vo = DozerConverter.parseObjet(repository.save(entity), BooksVo.class);
		return vo;
	}

	public void delete(Long id) {
		Books entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No resords for this ID"));
		repository.delete(entity);
	}

}
