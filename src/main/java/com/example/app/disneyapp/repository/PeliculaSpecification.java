package com.example.app.disneyapp.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.example.app.disneyapp.dto.PeliculaFilterDTO;
import com.example.app.disneyapp.entity.Pelicula;

@Component
public class PeliculaSpecification {

	public Specification<Pelicula> getByFilters(PeliculaFilterDTO filterDTO){
		return (root, query, criteriaBuilder) -> {
			List<Predicate> predicates = new ArrayList<>();
			
			if(StringUtils.hasLength(filterDTO.getTitle())) {
					predicates.add(
							criteriaBuilder.like(
												criteriaBuilder.lower(root.get("titulo")),
												"%" + filterDTO.getTitle().toLowerCase() + "%"
							)	
					);
			}
			
			if(StringUtils.hasLength(filterDTO.getGenre())){
				predicates.add(
						criteriaBuilder.equal(root.get("genero"), Long.parseLong(filterDTO.getGenre()))
				);
			}
			
			query.distinct(true);
			
			String orderByField = "titulo";
			query.orderBy(
					filterDTO.isASC() ?
							criteriaBuilder.asc(root.get(orderByField)) :
							criteriaBuilder.desc(root.get(orderByField))
			);
			
			return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
		}; 
	}
}
