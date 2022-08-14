package com.example.app.disneyapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.disneyapp.dto.PeliculaDTO;
import com.example.app.disneyapp.dto.PeliculaRequestDTO;
import com.example.app.disneyapp.service.PeliculaService;

@RestController
@RequestMapping("peliculas")
public class PeliculaController {
	
	@Autowired
	private PeliculaService peliculaService;
	
	@PostMapping("/create")
	public ResponseEntity<PeliculaDTO> save(@RequestBody PeliculaRequestDTO pelicula) {
		PeliculaDTO peliculaGuardada = peliculaService.save(pelicula);
		return ResponseEntity.status(HttpStatus.CREATED).body(peliculaGuardada);
	}
}
