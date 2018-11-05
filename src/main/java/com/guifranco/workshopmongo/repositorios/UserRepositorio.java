package com.guifranco.workshopmongo.repositorios;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.guifranco.workshopmongo.dominios.User;

@Repository
public interface UserRepositorio extends MongoRepository<User, String> {

}
