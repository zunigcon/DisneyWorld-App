package com.example.app.disneyapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.app.disneyapp.entity.Genero;

public interface GeneroRepository extends JpaRepository<Genero, Long>{

	Optional<Genero> findById(Long id_genero);
}
