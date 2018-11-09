package com.guifranco.workshopmongo.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guifranco.workshopmongo.dominios.Post;
import com.guifranco.workshopmongo.repositorios.PostRepositorio;
import com.guifranco.workshopmongo.servicos.exceptions.ObjetoNaoEncontradoException;

@Service
public class PostService {

	@Autowired
	private PostRepositorio repo;
	
	public Post findByID(String id) {
		Post obj = repo.findById(id).orElse(null);;
		if (obj == null)
			throw new ObjetoNaoEncontradoException("Objeto não encontrado");
		else
			return obj;
	}

}
