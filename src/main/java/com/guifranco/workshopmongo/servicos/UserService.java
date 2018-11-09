package com.guifranco.workshopmongo.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guifranco.workshopmongo.dominios.User;
import com.guifranco.workshopmongo.repositorios.UserRepositorio;
import com.guifranco.workshopmongo.servicos.exceptions.ObjetoNaoEncontradoException;

@Service
public class UserService {

	@Autowired
	private UserRepositorio repo;
	
	public List<User> findAll () {
		return repo.findAll();
	}
	
	public User findByID(String id) {
		User user = repo.findById(id).orElse(null);;
		if (user == null)
			throw new ObjetoNaoEncontradoException("Objeto não encontrado");
		else
			return user;
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		findByID(id);
		repo.deleteById(id);;
	}
	
	public User update(User obj) {
		User novoUser = findByID(obj.getId());
		novoUser.setName(obj.getName());
		novoUser.setEmail(obj.getEmail());
		return repo.save(novoUser);
	}
	
}
