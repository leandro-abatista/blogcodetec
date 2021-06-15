package com.projeto.spring.blogcodetec.service;

import java.util.List;

import com.projeto.spring.blogcodetec.models.Post;

public interface PostService {

	List<Post> findAll();
	
	Post findById(Long id);
	
	Post save(Post post);
}
