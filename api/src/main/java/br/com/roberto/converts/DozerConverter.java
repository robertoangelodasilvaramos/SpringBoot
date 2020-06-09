package br.com.roberto.converts;

import java.util.ArrayList;
import java.util.List;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

public class DozerConverter {

	
	private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();
	
	
	public static <O, D> D parseObjet(O origin, Class<D> destination) {
		return mapper.map(origin, destination);
	}
	
	
	public static <O, D> List<D> parseListObjets(List<O> origin, Class<D> destination) {
		List<D> destinationObList = new ArrayList<D>();
		for (Object o : origin) {
			destinationObList.add(mapper.map(o, destination));
		}
		return destinationObList;
	}
}
