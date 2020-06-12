package com.example.workshopmongo.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.workshopmongo.domain.Post;

public class PostDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String id;
	private Date date;
	private String title;
	private String body;
	private AuthorDTO author;
	
	public PostDTO() {
		super();
	}

	public PostDTO(String id, Date date, String title, String body, AuthorDTO author) {
		super();
		this.id = id;
		this.date = date;
		this.title = title;
		this.body = body;
		this.author = author;
	}
	
	public PostDTO(Post post) {
		super();
		if(post != null) {
			this.id = post.getId();
			this.date = post.getDate();
			this.title = post.getTitle();
			this.body = post.getBody();
			this.author = post.getAuthor();
		}
	}
	
	public List<PostDTO> getListaPostDTO(List<Post> listaPost) {
		List<PostDTO> listaPostDTO = null;
		if(listaPost != null) {
			listaPostDTO = new ArrayList<>();
			for (Post post : listaPost) {
				listaPostDTO.add(new PostDTO(post.getId(), post.getDate(), post.getTitle(), post.getBody(), post.getAuthor()));
			}
			
		}
		return listaPostDTO;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public AuthorDTO getAuthor() {
		return author;
	}

	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}
	
	

}
