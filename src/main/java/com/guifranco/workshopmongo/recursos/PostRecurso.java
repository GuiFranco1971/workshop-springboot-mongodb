package com.guifranco.workshopmongo.recursos;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.guifranco.workshopmongo.dominios.Post;
import com.guifranco.workshopmongo.recursos.uil.URL;
import com.guifranco.workshopmongo.servicos.PostService;

@RestController
@RequestMapping(value="/posts")

public class PostRecurso {

	@Autowired
	private PostService servico;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Post> findByID(@PathVariable String id) {
		Post obj = servico.findByID(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(value="/titlesearch", method=RequestMethod.GET)
	public ResponseEntity<List<Post>> findByTitulo(@RequestParam(value="text", defaultValue="") String text) {
		text = URL.decodeParm(text);
		List<Post> lista = servico.findByTitulo(text);
		return ResponseEntity.ok().body(lista);
	}
	
	@RequestMapping(value="/fullsearch", method=RequestMethod.GET)
	public ResponseEntity<List<Post>> fullSearch(
			@RequestParam(value="text", defaultValue="") String text,
			@RequestParam(value="minDate", defaultValue="") String minDate,
			@RequestParam(value="maxDate", defaultValue="") String maxDate) {
		text = URL.decodeParm(text);
		Date min = URL.converteData(minDate, new Date(0L));
		Date max = URL.converteData(maxDate, new Date());
		List<Post> lista = servico.fullSearch(text, min, max);
		return ResponseEntity.ok().body(lista);
	}
	
}
