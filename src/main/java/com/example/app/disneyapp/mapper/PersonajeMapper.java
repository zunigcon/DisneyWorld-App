package com.example.app.disneyapp.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.app.disneyapp.dto.PersonajeDTO;
import com.example.app.disneyapp.entity.Personaje;

@Component
public class PersonajeMapper {
	
	public Personaje personajeDTO2Entity(PersonajeDTO personajeDTO) {
		Personaje personaje = new Personaje(personajeDTO.getNombre(), personajeDTO.getEdad(), 
				personajeDTO.getPeso(), personajeDTO.getHistoria(), personajeDTO.getImagen());
		return personaje;
	}
	
	public PersonajeDTO personaje2DTO(Personaje personaje) {
		PersonajeDTO personajeDTO = new PersonajeDTO(personaje.getId_personaje(), 
				personaje.getNombre(), personaje.getEdad(), personaje.getPeso(), 
				personaje.getHistoria(), personaje.getImagen());
		return personajeDTO;
	}
	
	public List<PersonajeDTO> personajeList2DTOList(List<Personaje> personajes){
		List<PersonajeDTO> listaPersonajes = new ArrayList<>();
		for(Personaje personaje : personajes) {
			listaPersonajes.add(personaje2DTO(personaje));
		}
		return listaPersonajes;
	}	
}
