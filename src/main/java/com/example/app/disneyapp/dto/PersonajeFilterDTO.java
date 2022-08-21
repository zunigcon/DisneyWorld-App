package com.example.app.disneyapp.dto;

import java.util.List;

public class PersonajeFilterDTO {
	
	private String name;
	
	private String age;
	
	private List<Long> movies;
	
	private String order;

	public PersonajeFilterDTO(String name, String age, List<Long> movies, String order) {
		super();
		this.name = name;
		this.age = age;
		this.movies = movies;
		this.order = order;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public List<Long> getMovies() {
		return movies;
	}

	public void setMovies(List<Long> movies) {
		this.movies = movies;
	}
	
	public boolean isASC() {
		return this.order.compareToIgnoreCase("ASC") == 0;
	}
	
	public boolean isDESC() {
		return this.order.compareToIgnoreCase("DESC") == 0;
	}
}
