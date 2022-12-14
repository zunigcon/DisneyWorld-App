package com.example.app.disneyapp.dto;

import java.time.LocalDate;
import java.util.List;

import com.example.app.disneyapp.entity.Genero;

public class PeliculaDTO {
	
	private Long id_pelicula;
	
	private String titulo;
	
	private LocalDate fecha_creacion;
	
	private int calificacion;
	
	private String imagen;
	
	private Genero genero;
	
	private List<PersonajeDTO> personajes;

	public PeliculaDTO() {
		super();
	}

	public PeliculaDTO(Long id_pelicula, String titulo, LocalDate fecha_creacion, int calificacion, String imagen,
			Genero genero) {
		super();
		this.id_pelicula = id_pelicula;
		this.titulo = titulo;
		this.fecha_creacion = fecha_creacion;
		this.calificacion = calificacion;
		this.imagen = imagen;
		this.genero = genero;
	}

	public Long getId_pelicula() {
		return id_pelicula;
	}

	public void setId_pelicula(Long id_pelicula) {
		this.id_pelicula = id_pelicula;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public LocalDate getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(LocalDate fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public int getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public List<PersonajeDTO> getPersonajes() {
		return personajes;
	}

	public void setPersonajes(List<PersonajeDTO> personajes) {
		this.personajes = personajes;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

}
