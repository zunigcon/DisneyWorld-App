package com.example.app.disneyapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.disneyapp.dto.PersonajeBasicDTO;
import com.example.app.disneyapp.dto.PersonajeDTO;
import com.example.app.disneyapp.service.PersonajeService;

@RestController
@RequestMapping("characters")
public class PersonajeController {
	
	@Autowired
	private PersonajeService personajeService;
	
	@GetMapping("/list")
	public ResponseEntity<List<PersonajeDTO>> getAll() {
		List<PersonajeDTO> listaPersonajes = personajeService.getAll();
		return ResponseEntity.status(HttpStatus.OK).body(listaPersonajes);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PersonajeDTO> detail(@PathVariable Long id){
		PersonajeDTO personaje = personajeService.detail(id);
		return ResponseEntity.status(HttpStatus.OK).body(personaje);
	}
	
	@GetMapping
	public ResponseEntity<List<PersonajeDTO>> detailsFilter(
			@RequestParam(required = false) String name,
			@RequestParam(required = false) String age,
			@RequestParam(required = false) List<Long> movies,
			@RequestParam(required = false, defaultValue = "ASC") String order
	){
		List<PersonajeDTO> personajes = this.personajeService.getByFilters(name, age, movies, order);
		return ResponseEntity.ok(personajes);
	}
	
	@PostMapping("/create")
	public ResponseEntity<PersonajeDTO> save(@RequestBody PersonajeDTO personaje) {
		PersonajeDTO personajeGuardado = personajeService.save(personaje);
		return ResponseEntity.status(HttpStatus.CREATED).body(personajeGuardado);
	}	
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<PersonajeDTO> edit(@RequestBody PersonajeBasicDTO personaje,
			@PathVariable Long id){
		PersonajeDTO personajeEditado = personajeService.editPersonaje(id, personaje);
		return ResponseEntity.status(HttpStatus.OK).body(personajeEditado);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		personajeService.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
}


