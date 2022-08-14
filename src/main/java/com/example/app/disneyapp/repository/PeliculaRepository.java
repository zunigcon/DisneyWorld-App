package com.example.app.disneyapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.app.disneyapp.entity.Pelicula;

public interface PeliculaRepository extends JpaRepository<Pelicula, Long>{

	public Optional<Pelicula> findById(Long id_pelicula);
}
