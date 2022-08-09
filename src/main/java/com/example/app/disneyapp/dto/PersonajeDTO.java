package com.example.app.disneyapp.dto;

public class PersonajeDTO {
	
	private Long id_personaje;
	
	private String nombre;
	
	private int edad;
	
	private double peso;
	
	private String historia;
	
	private String imagen;

	public PersonajeDTO(Long id_personaje, String nombre, int edad, double peso, String historia, String imagen) {
		super();
		this.id_personaje = id_personaje;
		this.nombre = nombre;
		this.edad = edad;
		this.peso = peso;
		this.historia = historia;
		this.imagen = imagen;
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
	
}
