package com.example.app.disneyapp.dto;

public class GeneroDTO {

private Long id_genero;
	
	private String nombre;
	
	private String imagen;

	public GeneroDTO(Long id_genero, String nombre, String imagen) {
		super();
		this.id_genero = id_genero;
		this.nombre = nombre;
		this.imagen = imagen;
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

}
