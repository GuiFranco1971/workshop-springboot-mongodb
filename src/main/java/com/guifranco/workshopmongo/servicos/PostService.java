package com.guifranco.workshopmongo.servicos;

import java.util.Date;
import java.util.List;

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
	
	public List<Post> findByTitulo(String texto) {
		// return repo.findByTituloContainingIgnoreCase(texto);
		return repo.pesquisaPorTitulo(texto);
	}
	
	public List<Post> fullSearch(String texto, Date minDate, Date maxDate) {
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		return repo.fullSearch(texto, minDate, maxDate);
	}		
}
