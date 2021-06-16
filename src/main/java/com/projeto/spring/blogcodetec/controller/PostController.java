package com.projeto.spring.blogcodetec.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.projeto.spring.blogcodetec.models.Post;
import com.projeto.spring.blogcodetec.service.PostService;

@Controller
public class PostController {
	
	@Autowired
	private PostService postService;
	
	//lista todos os posts cadastrados no banco de dados
	@RequestMapping(value = "/posts", method = RequestMethod.GET)
	public ModelAndView getPosts() {
		
		ModelAndView mv = new ModelAndView("posts");
		List<Post> posts = postService.findAll();
		
		mv.addObject("posts", posts);
		return mv;
	}
	
	@RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
	public ModelAndView getPostDetails(@PathVariable ("id") Long id) {
		
		ModelAndView mv = new ModelAndView("postDetails");
		Post post = postService.findById(id);
		
		mv.addObject("post", post);
		return mv;
	}
	
	@RequestMapping(value = "/newpost", method = RequestMethod.GET)
	public String getPostForm() {
		return "postForm";
	}
	
	@RequestMapping(value = "/newpost", method = RequestMethod.POST)
	public String savePost(@Valid Post post, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {//se for encontrado algum tipo de erro
			attributes.addFlashAttribute("messagem", "Verifique se os campos obrigatórios foram preenchidos!");
			return "redirect:/newpost";//volta para a página do newpost
		}
		
		post.setData(LocalDate.now());
		postService.save(post);
		
		return "redirect:/posts";
	}
}
