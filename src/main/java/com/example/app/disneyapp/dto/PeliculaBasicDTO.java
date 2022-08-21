package com.example.app.disneyapp.dto;

import java.time.LocalDate;

public class PeliculaBasicDTO {
	
	private String titulo;
	
	private LocalDate fecha_creacion;
	
	private int calificacion;
	
	private String imagen;

	public PeliculaBasicDTO(String titulo, LocalDate fecha_creacion, int calificacion, String imagen) {
		super();
		this.titulo = titulo;
		this.fecha_creacion = fecha_creacion;
		this.calificacion = calificacion;
		this.imagen = imagen;
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
	
}
