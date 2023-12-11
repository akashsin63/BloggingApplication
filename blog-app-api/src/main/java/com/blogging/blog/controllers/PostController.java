package com.blogging.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogging.blog.entites.Post;
import com.blogging.blog.payloads.PostDTO;
import com.blogging.blog.services.PostService;

@RestController
@RequestMapping("/api/")
public class PostController {
	
	@Autowired
	private PostService postService;
	//create
	

	@PostMapping("/user/{userId}/category/{categoryId}/posts")
	public ResponseEntity<PostDTO> createPost(@RequestBody PostDTO postDto, @PathVariable Integer userId,
			@PathVariable Integer categoryId) {
		PostDTO createPost = this.postService.createPost(postDto, userId, categoryId);
		return new ResponseEntity<PostDTO>(createPost, HttpStatus.CREATED);
	}

}
