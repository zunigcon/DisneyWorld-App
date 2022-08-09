package com.example.app.disneyapp.mapper;

import org.springframework.stereotype.Component;

import com.example.app.disneyapp.dto.GeneroDTO;
import com.example.app.disneyapp.entity.Genero;

@Component
public class GeneroMapper {

	public Genero generoDTO2Entity(GeneroDTO generoDTO) {
		Genero genero = new Genero(generoDTO.getNombre(), generoDTO.getImagen());
		return genero;
	}
	
	public GeneroDTO genero2DTO(Genero genero) {
		GeneroDTO generoDTO = new GeneroDTO(genero.getId_genero(), genero.getNombre(), 
				genero.getImagen());
		return generoDTO;
	}
}
