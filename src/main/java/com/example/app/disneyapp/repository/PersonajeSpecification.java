package com.example.app.disneyapp.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.example.app.disneyapp.dto.PersonajeFilterDTO;
import com.example.app.disneyapp.entity.Pelicula;
import com.example.app.disneyapp.entity.Personaje;

@Component
public class PersonajeSpecification {
	
	public Specification<Personaje> getByFilters(PersonajeFilterDTO filterDTO){
		return (root, query, criteriaBuilder) -> {
			List<Predicate> predicates = new ArrayList<>();
			
			if(StringUtils.hasLength(filterDTO.getName())) {
					predicates.add(
							criteriaBuilder.like(
												criteriaBuilder.lower(root.get("nombre")),
												"%" + filterDTO.getName().toLowerCase() + "%"
							)	
					);
			}
			
			if(StringUtils.hasLength(filterDTO.getAge())){
				predicates.add(
						criteriaBuilder.equal(root.get("edad"), filterDTO.getAge())
				);
			}
			
			if(!CollectionUtils.isEmpty(filterDTO.getMovies())) {
				Join<Pelicula, Personaje> join = root.join("peliculas",JoinType.INNER);
				Expression<String> peliculasID = join.get("id_pelicula");
				predicates.add(peliculasID.in(filterDTO.getMovies()));
			}
			
			query.distinct(true);
			
			String orderByField = "nombre";
			query.orderBy(
					filterDTO.isASC() ?
							criteriaBuilder.asc(root.get(orderByField)) :
							criteriaBuilder.desc(root.get(orderByField))
			);
			
			return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
		}; 
	}
}
