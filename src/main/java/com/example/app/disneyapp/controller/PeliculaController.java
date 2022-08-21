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

import com.example.app.disneyapp.dto.PeliculaBasicDTO;
import com.example.app.disneyapp.dto.PeliculaDTO;
import com.example.app.disneyapp.dto.PeliculaRequestDTO;
import com.example.app.disneyapp.service.PeliculaService;

@RestController
@RequestMapping("movies")
public class PeliculaController {
	
	@Autowired
	private PeliculaService peliculaService;
	
	@GetMapping("/list")
	public ResponseEntity<List<PeliculaDTO>> getAll() {
		List<PeliculaDTO> listaPeliculas = peliculaService.getAll();
		return ResponseEntity.status(HttpStatus.OK).body(listaPeliculas);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PeliculaDTO> detail(@PathVariable Long id){
		PeliculaDTO pelicula = peliculaService.detail(id);
		return ResponseEntity.status(HttpStatus.OK).body(pelicula);
	}
	
	@GetMapping
	public ResponseEntity<List<PeliculaDTO>> detailsFilter(
			@RequestParam(required = false) String name,
			@RequestParam(required = false) String genre,
			@RequestParam(required = false, defaultValue = "ASC") String order
	){
		List<PeliculaDTO> peliculas = peliculaService.getByFilters(name, genre, order);
		return ResponseEntity.ok(peliculas);
	}
	
	@PostMapping("/create")
	public ResponseEntity<PeliculaDTO> save(@RequestBody PeliculaRequestDTO pelicula) {
		PeliculaDTO peliculaGuardada = peliculaService.save(pelicula);
		return ResponseEntity.status(HttpStatus.CREATED).body(peliculaGuardada);
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<PeliculaDTO> edit(@RequestBody PeliculaBasicDTO pelicula,
			@PathVariable Long id){
		PeliculaDTO peliculaEditada = peliculaService.editPelicula(id, pelicula);
		return ResponseEntity.status(HttpStatus.OK).body(peliculaEditada);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		peliculaService.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
