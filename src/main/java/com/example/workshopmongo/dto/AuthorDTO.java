package com.example.workshopmongo.dto;

import com.example.workshopmongo.domain.User;

public class AuthorDTO {
	
	private String id;
	private String name;
	
	public AuthorDTO() {
		super();
	}
	
	public AuthorDTO(User user) {
		if(user != null) {
			this.id = user.getId();
			this.name = user.getName();
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
