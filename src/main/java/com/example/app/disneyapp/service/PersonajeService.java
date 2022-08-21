package com.example.app.disneyapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.disneyapp.dto.PersonajeBasicDTO;
import com.example.app.disneyapp.dto.PersonajeDTO;
import com.example.app.disneyapp.dto.PersonajeFilterDTO;
import com.example.app.disneyapp.entity.Personaje;
import com.example.app.disneyapp.mapper.PersonajeMapper;
import com.example.app.disneyapp.repository.PersonajeRepository;
import com.example.app.disneyapp.repository.PersonajeSpecification;

@Service
public class PersonajeService {
	
	@Autowired
	private PersonajeMapper personajeMapper;
	
	@Autowired
	private PersonajeRepository personajeRepository;
	
	@Autowired
	private PersonajeSpecification personajeSpecification;
	
	public List<PersonajeDTO> getAll(){
		List<Personaje> listaPersonajes = personajeRepository.findAll();
		List<PersonajeDTO> resultadoPersonajes = personajeMapper.personajeList2DTOList(listaPersonajes,false);
		return resultadoPersonajes;
	}
	
	public PersonajeDTO detail(Long id) {
		Personaje personaje = personajeRepository.findById(id).get();
		PersonajeDTO personajeDTO = personajeMapper.personaje2DTO(personaje, true);
		return personajeDTO;
	}
	
	public PersonajeDTO save(PersonajeDTO dto) {
		Personaje personaje = personajeMapper.personajeDTO2Entity(dto);
		Personaje personajeGuardado = personajeRepository.save(personaje);
		PersonajeDTO personajeDTO = personajeMapper.personaje2DTO(personajeGuardado,false);
		return personajeDTO;
	}
	
	public PersonajeDTO editPersonaje(Long personajeID, PersonajeBasicDTO dto) {
		Personaje editPersonaje = personajeRepository.findById(personajeID).get();
		editPersonaje.setNombre(dto.getNombre());
		editPersonaje.setEdad(dto.getEdad());
		editPersonaje.setPeso(dto.getPeso());
		editPersonaje.setHistoria(dto.getHistoria());
		editPersonaje.setImagen(dto.getImagen());
		Personaje personajeEditado = personajeRepository.save(editPersonaje);
		PersonajeDTO peliculaDTO = personajeMapper.personaje2DTO(personajeEditado,true);
		return peliculaDTO;
	}
	
	public void delete(Long id) {
		personajeRepository.deleteById(id);
	}
	
	public List<PersonajeDTO> getByFilters(String name, String age, List<Long> movies, String order){
		PersonajeFilterDTO filterDTO = new PersonajeFilterDTO(name, age, movies, order);
		List<Personaje> personajes = personajeRepository.findAll(personajeSpecification.getByFilters(filterDTO));
		List<PersonajeDTO> dtoPersonaje = personajeMapper.personajeList2DTOList(personajes,false);
		return dtoPersonaje;
	}
}
