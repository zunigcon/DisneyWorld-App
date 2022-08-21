package com.example.app.disneyapp.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="personaje")
public class Personaje {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_personaje;
	
	@Column(length=45, nullable=false, unique=true)
	private String nombre;
	
	@Column
	private int edad;
	
	@Column
	private double peso;
	
	@Column(length=100)
	private String historia;
	
	@Column
	private String imagen;
	
	@ManyToMany
	@JoinTable(
			name="personaje_pelicula",
			joinColumns = @JoinColumn(name="id_personaje"),
			inverseJoinColumns = @JoinColumn(name="id_pelicula")
	)
	@JsonIgnore
	private List<Pelicula> peliculas = new ArrayList<>();

	public Personaje() {
		super();
	}
	
	public Personaje(String nombre, int edad, double peso, String historia, String imagen) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.peso = peso;
		this.historia = historia;
		this.imagen = imagen;
	}

	public Personaje(String nombre, int edad, double peso, String historia, String imagen, List<Pelicula> peliculas) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.peso = peso;
		this.historia = historia;
		this.imagen = imagen;
		this.peliculas = peliculas;
	}

	public Long getId_personaje() {
		return id_personaje;
	}

	public void setId_personaje(Long id_personaje) {
		this.id_personaje = id_personaje;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public String getHistoria() {
		return historia;
	}

	public void setHistoria(String historia) {
		this.historia = historia;
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
