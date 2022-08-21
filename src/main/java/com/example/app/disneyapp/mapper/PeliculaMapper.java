package com.example.app.disneyapp.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.app.disneyapp.dto.PeliculaDTO;
import com.example.app.disneyapp.dto.PeliculaRequestDTO;
import com.example.app.disneyapp.dto.PersonajeDTO;
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
	
	@Autowired
	private PersonajeMapper personajeMapper;

	public Pelicula peliculaDTO2Entity(PeliculaDTO peliculaDTO) {
		Pelicula pelicula = new Pelicula(peliculaDTO.getTitulo(),
				peliculaDTO.getFecha_creacion(), peliculaDTO.getCalificacion(), peliculaDTO.getImagen(), 
				peliculaDTO.getGenero());
		return pelicula;
	}
	
	public Pelicula peliculaDTO2EntityRequest(PeliculaRequestDTO peliculaRequestDTO) {
		Pelicula pelicula = new Pelicula();
		pelicula.setTitulo(peliculaRequestDTO.getTitulo());
		pelicula.setFecha_creacion(peliculaRequestDTO.getFecha_creacion());
		pelicula.setCalificacion(peliculaRequestDTO.getCalificacion());
		pelicula.setImagen(peliculaRequestDTO.getImagen()); 
		Genero g = generoRepository.findById(peliculaRequestDTO.getGenero()).get();
		pelicula.setGenero(g); 
		List<Personaje> personajes = new ArrayList<>(); 
		for(Long personajeID : peliculaRequestDTO.getPersonajes()) {
			Personaje personaje = personajeRepository.findById(personajeID).get();
			personajes.add(personaje);
		}
		pelicula.setPersonajes(personajes);
		return pelicula;
	}
	
	public PeliculaDTO pelicula2DTO(Pelicula pelicula, boolean loadPersonajes) {
		PeliculaDTO peliculaDTO = new PeliculaDTO(pelicula.getId_pelicula(), pelicula.getTitulo(),
				pelicula.getFecha_creacion(), pelicula.getCalificacion(), pelicula.getImagen(), 
				pelicula.getGenero());
		
		if(loadPersonajes) {
			List<PersonajeDTO> personajeDTO = personajeMapper.personajeList2DTOList(pelicula.getPersonajes(), false);
			peliculaDTO.setPersonajes(personajeDTO);	
		}
		
		return peliculaDTO;
	}
	
	public List<PeliculaDTO> peliculaList2DTOList(List<Pelicula> peliculas, boolean loadPersonajes){
		List<PeliculaDTO> listaPeliculas = new ArrayList<>();
		for(Pelicula pelicula : peliculas) {
			listaPeliculas.add(pelicula2DTO(pelicula,false));
		}
		return listaPeliculas;
	}
	
	public List<Pelicula> peliculaDTOList2Entity(List<PeliculaDTO> peliculas){
		List<Pelicula> listaPeliculas = new ArrayList<>();
		for(PeliculaDTO pelicula : peliculas) {
			listaPeliculas.add(peliculaDTO2Entity(pelicula));
		}
		return listaPeliculas;
	}
}
