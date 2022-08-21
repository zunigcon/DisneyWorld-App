package com.example.app.disneyapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.disneyapp.dto.PeliculaBasicDTO;
import com.example.app.disneyapp.dto.PeliculaDTO;
import com.example.app.disneyapp.dto.PeliculaFilterDTO;
import com.example.app.disneyapp.dto.PeliculaRequestDTO;
import com.example.app.disneyapp.entity.Pelicula;
import com.example.app.disneyapp.mapper.PeliculaMapper;
import com.example.app.disneyapp.repository.PeliculaRepository;
import com.example.app.disneyapp.repository.PeliculaSpecification;

@Service
public class PeliculaService {
	
	@Autowired
	private PeliculaMapper peliculaMapper;
	
	@Autowired
	private PeliculaRepository peliculaRepository;
	
	@Autowired
	private PeliculaSpecification peliculaSpecification;
	
	public List<PeliculaDTO> getAll(){
		List<Pelicula> listaPeliculas = peliculaRepository.findAll();
		List<PeliculaDTO> resultadoPeliculas = peliculaMapper.peliculaList2DTOList(listaPeliculas,false);
		return resultadoPeliculas;
	}
	
	public PeliculaDTO detail(Long id) {
		Pelicula pelicula = peliculaRepository.findById(id).get();
		PeliculaDTO peliculaDTO = peliculaMapper.pelicula2DTO(pelicula, true);
		return peliculaDTO;
	}
	
	public PeliculaDTO save(PeliculaRequestDTO dto) {
		Pelicula pelicula = peliculaMapper.peliculaDTO2EntityRequest(dto);
		Pelicula peliculaGuardado = peliculaRepository.save(pelicula);
		PeliculaDTO peliculaDTO = peliculaMapper.pelicula2DTO(peliculaGuardado,false);
		return peliculaDTO;
	}
	
	public List<PeliculaDTO> getByFilters(String name, String genre, String order){
		PeliculaFilterDTO filterDTO = new PeliculaFilterDTO(name, genre, order);
		List<Pelicula> personajes = peliculaRepository.findAll(peliculaSpecification.getByFilters(filterDTO));
		List<PeliculaDTO> dtoPersonaje = peliculaMapper.peliculaList2DTOList(personajes, false);
		return dtoPersonaje;
	}
	
	public PeliculaDTO editPelicula(Long peliculaID, PeliculaBasicDTO dto) {
		Pelicula editPelicula = peliculaRepository.findById(peliculaID).get();
		editPelicula.setTitulo(dto.getTitulo());
		editPelicula.setFecha_creacion(dto.getFecha_creacion());
		editPelicula.setCalificacion(dto.getCalificacion());
		editPelicula.setImagen(dto.getImagen());
		Pelicula peliculaEditada = peliculaRepository.save(editPelicula);
		PeliculaDTO peliculaDTO = peliculaMapper.pelicula2DTO(peliculaEditada,true);
		return peliculaDTO;
	}
	
	public void delete(Long id) {
		peliculaRepository.deleteById(id);
	}
}
