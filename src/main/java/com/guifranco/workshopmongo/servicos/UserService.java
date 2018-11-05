package com.guifranco.workshopmongo.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guifranco.workshopmongo.dominios.User;
import com.guifranco.workshopmongo.repositorios.UserRepositorio;

@Service
public class UserService {

	@Autowired
	private UserRepositorio repo;
	
	public List<User> findAll () {
		return repo.findAll();
	}
}
