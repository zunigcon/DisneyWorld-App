package com.example.app.disneyapp.mapper;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.app.disneyapp.dto.PeliculaDTO;
import com.example.app.disneyapp.dto.PeliculaRequestDTO;
import com.example.app.disneyapp.entity.Genero;
import com.example.app.disneyapp.entity.Pelicula;
import com.example.app.disneyapp.entity.Personaje;
import com.example.app.disneyapp.repository.GeneroRepository;
import com.example.app.disneyapp.repository.PersonajeRepository;

@Component
public class PeliculaMapper {
	
	@Autowired
	private PersonajeRepository personajeRepository;
	
	@Autowired
	private GeneroRepository generoRepository;

	public Pelicula peliculaDTO2Entity(PeliculaRequestDTO peliculaRequestDTO) {
		Pelicula pelicula = new Pelicula();
		pelicula.setTitulo(peliculaRequestDTO.getTitulo());
		pelicula.setFecha_creacion(peliculaRequestDTO.getFecha_creacion());
		pelicula.setCalificacion(peliculaRequestDTO.getCalificacion());
		pelicula.setImagen(peliculaRequestDTO.getImagen()); 
		Genero g = generoRepository.findById(peliculaRequestDTO.getGenero()).get();
		pelicula.setGenero(g); 
		Set<Personaje> personajes = new HashSet<>(); 
		for(Long personajeID : peliculaRequestDTO.getPersonajes()) {
			Personaje personaje = personajeRepository.findById(personajeID).get();
			personajes.add(personaje);
		}
		pelicula.setPersonajes(personajes);
		return pelicula;
	}
	
	public PeliculaDTO pelicula2DTO(Pelicula pelicula) {
		PeliculaDTO peliculaDTO = new PeliculaDTO(pelicula.getId_pelicula(), pelicula.getTitulo(),
				pelicula.getFecha_creacion(), pelicula.getCalificacion(), pelicula.getImagen(), 
				pelicula.getGenero(), pelicula.getPersonajes());
		return peliculaDTO;
	}
}
