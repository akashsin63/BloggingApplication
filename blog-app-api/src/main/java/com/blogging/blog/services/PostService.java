package com.blogging.blog.services;
import java.util.List;

import com.blogging.blog.entites.*;
import com.blogging.blog.payloads.PostDTO;
import com.blogging.blog.payloads.PostResponse;

public interface PostService {
	//create
	//create 

	PostDTO createPost(PostDTO postDto,Integer userId,Integer categoryId);

	//update 

	PostDTO updatePost(PostDTO postDto, Integer postId);

	// delete

	void deletePost(Integer postId);
	
	//get all posts
	
	PostResponse getAllPost(Integer pageNumber,Integer pageSize,String sortBy,String sortDir);
	
	//get single post
	
	PostDTO getPostById(Integer postId);
	
	//get all posts by category
	
	List<PostDTO> getPostsByCategory(Integer categoryId);
	
	//get all posts by user
	List<PostDTO> getPostsByUser(Integer userId);
	
	//search posts
	List<PostDTO> searchPosts(String keyword);
	
}
