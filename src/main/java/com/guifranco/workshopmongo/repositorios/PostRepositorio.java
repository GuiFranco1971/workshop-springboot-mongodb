package com.guifranco.workshopmongo.repositorios;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.guifranco.workshopmongo.dominios.Post;

@Repository
public interface PostRepositorio extends MongoRepository<Post, String> {

}