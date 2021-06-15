package com.projeto.spring.blogcodetec.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.spring.blogcodetec.models.Post;
import com.projeto.spring.blogcodetec.repository.PostRepository;
import com.projeto.spring.blogcodetec.service.PostService;

@Service // bean gerenciado pelo spring
public class PostServiceImplement implements PostService {

	@Autowired
	private PostRepository postRepository;

	@Override
	public List<Post> findAll() {
		// retorna uma lista
		return postRepository.findAll();
	}

	@Override
	public Post findById(Long id) {
		// retorna um post pelo id
		return postRepository.findById(id).get();
	}

	@Override
	public Post save(Post post) {
		// salva um novo post
		return postRepository.save(post);
	}

}
