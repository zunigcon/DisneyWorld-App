package com.example.app.disneyapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.disneyapp.dto.PersonajeDTO;
import com.example.app.disneyapp.entity.Personaje;
import com.example.app.disneyapp.mapper.PersonajeMapper;
import com.example.app.disneyapp.repository.PersonajeRepository;

@Service
public class PersonajeService {
	
	@Autowired
	private PersonajeMapper personajeMapper;
	
	@Autowired
	private PersonajeRepository personajeRepository;
	
	public List<PersonajeDTO> getAll(){
		List<Personaje> listaPersonajes = personajeRepository.findAll();
		List<PersonajeDTO> resultadoPersonajes = personajeMapper.personajeList2DTOList(listaPersonajes);
		return resultadoPersonajes;
	}
	
	public PersonajeDTO save(PersonajeDTO dto) {
		Personaje personaje = personajeMapper.personajeDTO2Entity(dto);
		Personaje personajeGuardado = personajeRepository.save(personaje);
		PersonajeDTO personajeDTO = personajeMapper.personaje2DTO(personajeGuardado);
		return personajeDTO;
	}
	
	public void delete(Long id) {
		personajeRepository.deleteById(id);
	}
}
