package com.blogging.blog.services.impl;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogging.blog.entites.Category;
import com.blogging.blog.entites.Post;
import com.blogging.blog.entites.Users;
import com.blogging.blog.execptions.ResourceNotFoundException;
import com.blogging.blog.payloads.PostDTO;
import com.blogging.blog.payloads.PostResponse;
import com.blogging.blog.reposetories.CategoryRepo;
import com.blogging.blog.reposetories.PostRepo;
import com.blogging.blog.reposetories.UserRepo;
import com.blogging.blog.services.PostService;


	@Service
	public class PostServiceImpl implements PostService {

	    @Autowired
	    private PostRepo postRepo;

	    @Autowired
	    private ModelMapper modelMapper;

	    @Autowired
	    private UserRepo userRepo;

	    @Autowired
	    private CategoryRepo categoryRepo;

	    @Override
	    public PostDTO createPost(PostDTO postDto, Integer userId, Integer categoryId) {

	        Users user = this.userRepo.findById(userId)
	                .orElseThrow(() -> new ResourceNotFoundException("User ", "User id", userId));

	        Category category = this.categoryRepo.findById(categoryId)
	                .orElseThrow(() -> new ResourceNotFoundException("Category", "category id ", categoryId));

	        Post post = this.modelMapper.map(postDto, Post.class);
	        post.setImageName("default.png");
	        post.setAddedDate(new Date());
	        post.setUser(user);
	        post.setCategory(category);

	        Post newPost = this.postRepo.save(post);

	        return this.modelMapper.map(newPost, PostDTO.class);
	    }

	    @Override
	    public PostDTO updatePost(PostDTO postDto, Integer postId) {

	       return null;
	    }

	    @Override
	    public void deletePost(Integer postId) {

	    }

	    @Override
	    public PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy, String sortDir) {

	    	 return null;
	    }

	    @Override
	    public PostDTO getPostById(Integer postId) {
	    	 return null;
	    }

	    @Override
	    public List<PostDTO> getPostsByCategory(Integer categoryId) {

	        return null;
	    }

	    @Override
	    public List<PostDTO> getPostsByUser(Integer userId) {
	    	 return null;
	    }

	    @Override
	    public List<PostDTO> searchPosts(String keyword) {
	       return null;
	    }

	}

