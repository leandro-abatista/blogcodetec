package com.projeto.spring.blogcodetec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.projeto.spring.blogcodetec.models.Post;
import com.projeto.spring.blogcodetec.service.PostService;

@Controller
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@RequestMapping(value = "/posts", method = RequestMethod.GET)
	public ModelAndView getPosts() {
		
		ModelAndView mv = new ModelAndView("posts");
		List<Post> posts = postService.findAll();
		
		mv.addObject("posts", posts);
		return mv;
	}
}
