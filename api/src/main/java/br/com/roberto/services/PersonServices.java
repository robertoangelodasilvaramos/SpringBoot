package br.com.roberto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.roberto.converter.custom.PersonConverter;
import br.com.roberto.converts.DozerConverter;
import br.com.roberto.data.model.Person;
import br.com.roberto.data.vo.PersonVo;

import br.com.roberto.exception.ResourceNotFoundException;
import br.com.roberto.repository.PersonRepository;

@Service
public class PersonServices {

	@Autowired
	PersonRepository repository;

	@Autowired
	PersonConverter converter;

	public PersonVo findById(Long id) {
		var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No resords for this ID"));

		return DozerConverter.parseObjet(entity, PersonVo.class);
	}

	@Transactional
	public PersonVo disablePerson(Long id) {
		repository.disablePersons(id);
		var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No resords for this ID"));

		return DozerConverter.parseObjet(entity, PersonVo.class);
	}

	public List<PersonVo> findByAll(Pageable pegeable) {
		var entities = repository.findAll(pegeable).getContent();
		
		return  DozerConverter.parseListObjets(entities, PersonVo.class);
	
	}

	

	

	public PersonVo create(PersonVo person) {
		Person entity = DozerConverter.parseObjet(person, Person.class);
		var vo = DozerConverter.parseObjet(repository.save(entity), PersonVo.class);
		return vo;
	}

	public PersonVo update(PersonVo person) {
		var entity = repository.findById(person.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No resords for this ID"));
		entity.setFistName(person.getFistName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		var vo = DozerConverter.parseObjet(repository.save(entity), PersonVo.class);
		return vo;
	}

	public void delete(Long id) {
		Person entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No resords for this ID"));
		repository.delete(entity);
	}

}
