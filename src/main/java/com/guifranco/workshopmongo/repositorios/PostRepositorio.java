package com.guifranco.workshopmongo.repositorios;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.guifranco.workshopmongo.dominios.Post;

@Repository
public interface PostRepositorio extends MongoRepository<Post, String> {
	
	public List<Post> findByTituloContainingIgnoreCase(String texto);

}
