package com.example.app.disneyapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.disneyapp.dto.PersonajeDTO;
import com.example.app.disneyapp.service.PersonajeService;

@RestController
@RequestMapping("personajes")
public class PersonajeController {
	
	@Autowired
	private PersonajeService personajeService;
	
	@GetMapping("/list")
	public ResponseEntity<List<PersonajeDTO>> getAll() {
		List<PersonajeDTO> listaPersonajes = personajeService.getAll();
		return ResponseEntity.status(HttpStatus.OK).body(listaPersonajes);
	}
	
	@PostMapping("/create")
	public ResponseEntity<PersonajeDTO> save(@RequestBody PersonajeDTO personaje) {
		PersonajeDTO personajeGuardado = personajeService.save(personaje);
		return ResponseEntity.status(HttpStatus.CREATED).body(personajeGuardado);
	}	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		personajeService.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
