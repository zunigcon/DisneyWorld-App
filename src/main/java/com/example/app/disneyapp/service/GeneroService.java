package com.example.app.disneyapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.disneyapp.dto.GeneroDTO;
import com.example.app.disneyapp.entity.Genero;
import com.example.app.disneyapp.mapper.GeneroMapper;
import com.example.app.disneyapp.repository.GeneroRepository;

@Service
public class GeneroService {
	
	@Autowired
	private GeneroRepository generoRepository;
	
	@Autowired
	private GeneroMapper generoMapper;
	
	public GeneroDTO save(GeneroDTO dto) {
		Genero genero = generoMapper.generoDTO2Entity(dto);
		Genero generoGuardado = generoRepository.save(genero);
		GeneroDTO generoDTO = generoMapper.genero2DTO(generoGuardado);
		return generoDTO;
	}
}
