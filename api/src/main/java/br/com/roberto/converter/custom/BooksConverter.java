package br.com.roberto.converter.custom;

import org.springframework.stereotype.Service;

import br.com.roberto.data.model.Books;
import br.com.roberto.data.vo.BooksVo;

@Service
public class BooksConverter {
	public BooksVo convertEntityToVO(Books books) {
		BooksVo vo = new BooksVo();
		vo.setId(books.getId());
		vo.setAuthor(books.getAuthor());
		;
		vo.setLaunchDate(books.getLaunchDate());
		vo.setPrice(books.getPrice());
		vo.setTitle(books.getTitle());
		return vo;
	}

	public Books convertEntity(BooksVo books) {
		Books entity = new Books();
		entity.setId(books.getId());
		entity.setId(books.getId());
		entity.setAuthor(books.getAuthor());
		;
		entity.setLaunchDate(books.getLaunchDate());
		entity.setPrice(books.getPrice());
		entity.setTitle(books.getTitle());
		return entity;
	}
}
