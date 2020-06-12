package com.example.workshopmongo.dto;

import java.io.Serializable;
import java.util.Date;

public class CommentsDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String texto;
	private Date date;
	private AuthorDTO author;
	
	public CommentsDTO() {
		super();
	}

	public CommentsDTO(String texto, Date date, AuthorDTO author) {
		super();
		this.texto = texto;
		this.date = date;
		this.author = author;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public AuthorDTO getAuthor() {
		return author;
	}

	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}
	
	

}
