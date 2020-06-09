package br.com.roberto.converter.custom;

import org.springframework.stereotype.Service;

import br.com.roberto.data.model.Person;
import br.com.roberto.data.vo.PersonVo;

@Service
public class PersonConverter {

	
	
	public PersonVo convertEntityToVO(Person person) {
		PersonVo vo =  new PersonVo();
		vo.setId(person.getId());
		vo.setAddress(person.getAddress());
		vo.setFistName(person.getFistName());
		vo.setGender(person.getGender());
		vo.setLastName(person.getGender());
		return vo;
	}
	
	public Person convertEntity(PersonVo person) {
		Person entity =  new Person();
		entity.setId(person.getId());
		entity.setAddress(person.getAddress());
		entity.setFistName(person.getFistName());
		entity.setGender(person.getGender());
		entity.setLastName(person.getGender());
		return entity;
	}
}
