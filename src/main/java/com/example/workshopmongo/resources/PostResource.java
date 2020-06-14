package com.example.workshopmongo.resources;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.workshopmongo.dto.PostDTO;
import com.example.workshopmongo.resources.util.URL;
import com.example.workshopmongo.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
	
	@Autowired
	private PostService postService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<PostDTO> findById(@PathVariable String id){

		return ResponseEntity.ok().body(new PostDTO(postService.findById(id)));
		
	}
	
	@GetMapping(value="/titleSearch")
	public ResponseEntity<List<PostDTO>> findByTitle(@RequestParam(value="text") String text){
		// Lembrar encodeURIComponent("bom dia")	
		return ResponseEntity.ok().body(new PostDTO().getListaPostDTO(postService.findByTitle(URL.decodeParameter(text))));
				
	}
	
	@GetMapping(value="/findSearch")
	public ResponseEntity<List<PostDTO>> findSearch(@RequestParam(value="texto", defaultValue="") String texto,
			                                        @RequestParam(value="minDate", defaultValue="") String minDate,
			                                        @RequestParam(value="maxDate", defaultValue="") String maxDate){
		
		texto = URL.decodeParameter(texto);
		Date dataMinima = URL.converteData(minDate, new Date(0L));
		Date dataMaxima = URL.converteData(maxDate, new Date());
		
		return ResponseEntity.ok().body(new PostDTO().getListaPostDTO(postService.findSearch(texto, dataMinima, dataMaxima)));
		
	}
	
	

}
