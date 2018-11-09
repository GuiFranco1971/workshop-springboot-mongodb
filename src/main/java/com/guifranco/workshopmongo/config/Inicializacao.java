package com.guifranco.workshopmongo.config;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.guifranco.workshopmongo.dominios.Post;
import com.guifranco.workshopmongo.dominios.User;
import com.guifranco.workshopmongo.dto.AutorDTO;
import com.guifranco.workshopmongo.repositorios.PostRepositorio;
import com.guifranco.workshopmongo.repositorios.UserRepositorio;

@Configuration
public class Inicializacao implements CommandLineRunner {
	
	@Autowired
	private UserRepositorio userRepositorio;
	
	@Autowired
	private PostRepositorio postRepositorio;
		
	@Override
	public void run(String... args) throws Exception {

	//	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	//	sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		Date dataHoraAgora = new Date();
		
		userRepositorio.deleteAll();
		postRepositorio.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepositorio.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, new AutorDTO(maria),  dataHoraAgora, "Partiu viagem", "Vou viajar para São Paulo. Abraços!");
		Post post2 = new Post(null, new AutorDTO(maria),  dataHoraAgora, "Bom dia", "Acordei feliz hoje!");
				
		postRepositorio.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userRepositorio.save(maria);
		
	}
	
}
