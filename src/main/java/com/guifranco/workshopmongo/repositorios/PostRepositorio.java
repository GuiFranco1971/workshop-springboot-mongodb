package com.guifranco.workshopmongo.repositorios;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.guifranco.workshopmongo.dominios.Post;

@Repository
public interface PostRepositorio extends MongoRepository<Post, String> {
	
	public List<Post> findByTituloContainingIgnoreCase(String texto);
	
	//este método abaixo é exatamente igual ao de cima, apenas
	//usando agora o @Query do MongoDB
	
	@Query("{ 'titulo': { $regex: ?0, $options: 'i' } }")
	public List<Post> pesquisaPorTitulo(String texto);

}
