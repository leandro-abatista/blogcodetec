package com.projeto.spring.blogcodetec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.spring.blogcodetec.models.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
