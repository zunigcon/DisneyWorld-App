package com.example.app.disneyapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.disneyapp.dto.PeliculaDTO;
import com.example.app.disneyapp.dto.PeliculaRequestDTO;
import com.example.app.disneyapp.entity.Pelicula;
import com.example.app.disneyapp.mapper.PeliculaMapper;
import com.example.app.disneyapp.repository.PeliculaRepository;

@Service
public class PeliculaService {
	
	@Autowired
	private PeliculaMapper peliculaMapper;
	
	@Autowired
	private PeliculaRepository peliculaRepository;
	
	public PeliculaDTO save(PeliculaRequestDTO dto) {
		Pelicula pelicula = peliculaMapper.peliculaDTO2Entity(dto);
		Pelicula peliculaGuardado = peliculaRepository.save(pelicula);
		PeliculaDTO peliculaDTO = peliculaMapper.pelicula2DTO(peliculaGuardado);
		return peliculaDTO;
	}
}
