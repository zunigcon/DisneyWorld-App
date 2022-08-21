package com.example.app.disneyapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.app.disneyapp.entity.Pelicula;

public interface PeliculaRepository extends JpaRepository<Pelicula, Long>, JpaSpecificationExecutor<Pelicula>{

	Optional<Pelicula> findById(Long id_pelicula);
	
	List<Pelicula> findAll(Specification<Pelicula> spec);
}
