package com.example.workshopmongo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
	
	//Consulta Simples com @Query
	@Query("{ title: { $regex: ?0, $options: 'i' } }")
	List<Post> findTitle(String text);
	
	//Utilizando vários Critérios com @Query
	@Query("{ $and: [ {date: {$gte: ?1} } , { date: { $lte: ?2} } , { $or: [ { title: { $regex: ?0, $options: 'i' } }, { body: { $regex: ?0, $options: 'i' } }  , { 'comments.texto': { $regex: ?0, $options: 'i' } } ] } ] }")
	List<Post> findSearch(String text, Date minDate, Date maxDate);
	
	//Utilizando Query Methods
	List<Post> findByTitleContainingIgnoreCase(String texto);
		

}
