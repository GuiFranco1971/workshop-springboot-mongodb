package com.guifranco.workshopmongo.recursos;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.guifranco.workshopmongo.dominios.User;
import com.guifranco.workshopmongo.dto.UserDTO;
import com.guifranco.workshopmongo.servicos.UserService;

@RestController
@RequestMapping(value="/users")

public class UserRecurso {

	@Autowired
	private UserService servico;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> lista = servico.findAll();
		List<UserDTO> listaDTO = lista.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listaDTO);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<UserDTO> findByID(@PathVariable String id) {
		User user = servico.findByID(id);
		return ResponseEntity.ok().body(new UserDTO(user));
	}
}
