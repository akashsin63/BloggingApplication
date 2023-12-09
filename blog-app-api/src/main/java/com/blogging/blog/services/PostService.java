package com.blogging.blog.services;
import java.util.List;

import com.blogging.blog.entites.*;
import com.blogging.blog.payloads.PostDTO;

public interface PostService {
	//create
	PostDTO createPost(PostDTO postDto, Integer userId , Integer categoryId) ;
	
	//update 
	Post updatePost(PostDTO postDto,Integer postId);
	
	//delete
	
	void deletePost(Integer postId);
	
	//Get Post
	
	Post getPost(Integer postId);
	
	//Get ALl post
	
	List<Post> getAllPost();
	
	Post getPostById(Integer postId);
	//get All post by category
	List<Post> getPostByCategory(Integer CategoryId);
	
	//get Post by User
	
	List<Post> getPostByUser(Integer userId);
	
	
	//Search post 
	List<Post> searchPosts(String keyword);
	
}
