package com.projeto.spring.blogcodetec.util;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.projeto.spring.blogcodetec.models.Post;
import com.projeto.spring.blogcodetec.repository.PostRepository;

@Component
public class DummyData {

	@Autowired
	private PostRepository postRepository;
	
	//@PostConstruct
	public void savePosts() {
		
		List<Post> postList = new ArrayList<>();
		
		Post post1 = new Post();
		post1.setAutor("Leandro Amorim");
		post1.setData(LocalDate.now());
		post1.setTitulo("Docker");
		post1.setTexto("É mais testes para verificar se ta funcionando corretamente.");
		
		Post post2 = new Post();
		post2.setAutor("Leandro Amorim");
		post2.setData(LocalDate.now());
		post2.setTitulo("API REST");
		post2.setTexto("É mais testes para verificar se ta funcionando corretamente a apirest.");
		
		postList.add(post1);
		postList.add(post2);
		
		for (Post post : postList) {
			Post postSaved = postRepository.save(post);
			System.out.println(postSaved.getId());
		}
	}
}
