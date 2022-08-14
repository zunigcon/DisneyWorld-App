package com.example.app.disneyapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.app.disneyapp.entity.Personaje;

@Repository
public interface PersonajeRepository extends JpaRepository<Personaje, Long>{

	public Optional<Personaje> findById(Long id_personaje);
}
