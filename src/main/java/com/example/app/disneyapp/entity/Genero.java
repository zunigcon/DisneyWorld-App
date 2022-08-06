package com.example.app.disneyapp.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="genero")
public class Genero {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_genero;
	
	@Column(length=45, nullable=false, unique=true)
	private String nombre;
	
	@Column
	private String imagen;
	
	@OneToMany(mappedBy="genero")
	private List<Pelicula> peliculas;
	
	public Genero() {
		super();
	}
	
	public Genero(String nombre, String imagen, List<Pelicula> peliculas) {
		super();
		this.nombre = nombre;
		this.imagen = imagen;
		this.peliculas = peliculas;
	}

	public Long getId_genero() {
		return id_genero;
	}

	public void setId_genero(Long id_genero) {
		this.id_genero = id_genero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public List<Pelicula> getPeliculas() {
		return peliculas;
	}

	public void setPeliculas(List<Pelicula> peliculas) {
		this.peliculas = peliculas;
	}

}
