package com.guifranco.workshopmongo.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.guifranco.workshopmongo.dominios.User;
import com.guifranco.workshopmongo.servicos.UserService;

@RestController
@RequestMapping(value="/users")

public class UserRecurso {

	@Autowired
	private UserService servico;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<User>> findAll() {
		List<User> lista = servico.findAll();
		return ResponseEntity.ok().body(lista);
	}
}