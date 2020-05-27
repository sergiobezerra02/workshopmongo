package com.example.workshopmongo.dto;

import java.io.Serializable;

import com.example.workshopmongo.domain.User;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class UserDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private String email;
	
	public UserDTO() {
		super();
	}
	
	public UserDTO(User user) {
		if(user != null) {
			this.id = user.getId();
			this.name = user.getName();
			this.email = user.getEmail();
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Pattern(regexp = "\\p{L}+", message = "Atenção! Nome não deve possuir números.")
	@NotEmpty(message = "Atenção!: Nome não pode ser nulo.")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
