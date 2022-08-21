package com.example.app.disneyapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.example.app.disneyapp.entity.Personaje;

@Repository
public interface PersonajeRepository extends JpaRepository<Personaje, Long>, JpaSpecificationExecutor<Personaje>{

	Optional<Personaje> findById(Long id_personaje);
	
	List<Personaje> findAll(Specification<Personaje> spec);
}
