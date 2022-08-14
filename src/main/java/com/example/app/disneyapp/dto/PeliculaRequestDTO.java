package com.example.app.disneyapp.dto;

import java.time.LocalDate;
import java.util.Set;

public class PeliculaRequestDTO {
	
private Long id_pelicula;
	
	private String titulo;
	
	private LocalDate fecha_creacion;
	
	private int calificacion;
	
	private String imagen;
	
	private Long genero;
	
	private Set<Long> personajes;

	public PeliculaRequestDTO() {
		super();
	}

	public PeliculaRequestDTO(Long id_pelicula, String titulo, LocalDate fecha_creacion, int calificacion, String imagen,
			Long genero, Set<Long> personajes) {
		super();
		this.id_pelicula = id_pelicula;
		this.titulo = titulo;
		this.fecha_creacion = fecha_creacion;
		this.calificacion = calificacion;
		this.imagen = imagen;
		this.genero = genero;
		this.personajes = personajes;
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

	public Set<Long> getPersonajes() {
		return personajes;
	}

	public void setPersonajes(Set<Long> personajes) {
		this.personajes = personajes;
	}

	public Long getGenero() {
		return genero;
	}

	public void setGenero(Long genero) {
		this.genero = genero;
	}

}
