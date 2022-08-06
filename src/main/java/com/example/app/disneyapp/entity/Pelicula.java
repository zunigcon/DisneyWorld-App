package com.example.app.disneyapp.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="pelicula")
public class Pelicula {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_pelicula;
	
	@Column(length=50, nullable=false, unique=true)
	private String titulo;
	
	@Column
	private LocalDate fecha_creacion;
	
	@Column
	private int calificacion;
	
	@Column
	private String imagen;
	
	@ManyToOne
	@JoinColumn(name="id_genero")
	private Genero genero; 
	
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(
			name="personaje_pelicula",
			joinColumns = @JoinColumn(name="id_pelicula"),
			inverseJoinColumns = @JoinColumn(name="id_personaje")
	)
	private List<Personaje> personajes;

	public Pelicula() {
		super();
	}

	public Pelicula(String titulo, LocalDate fecha_creacion, int calificacion, String imagen, Genero genero,
			List<Personaje> personajes) {
		super();
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

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public List<Personaje> getPersonajes() {
		return personajes;
	}

	public void setPersonajes(List<Personaje> personajes) {
		this.personajes = personajes;
	}

}
