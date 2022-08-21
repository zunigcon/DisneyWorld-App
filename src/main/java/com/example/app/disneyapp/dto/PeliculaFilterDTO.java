package com.example.app.disneyapp.dto;

public class PeliculaFilterDTO {
	
	private String title;
	
	private String genre;
	
	private String order;

	public PeliculaFilterDTO(String title, String genre, String order) {
		super();
		this.title = title;
		this.genre = genre;
		this.order = order;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public boolean isASC() {
		return this.order.compareToIgnoreCase("ASC") == 0;
	}
	
	public boolean isDESC() {
		return this.order.compareToIgnoreCase("DESC") == 0;
	}
}
