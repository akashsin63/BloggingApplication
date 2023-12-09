package com.blogging.blog.reposetories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogging.blog.entites.Category;
import com.blogging.blog.entites.Post;
import com.blogging.blog.entites.Users;

public interface PostRepo extends JpaRepository<Post,Integer> {

	
	List<Post> findByUsers(Users user);
	List<Post> findByCategory(Category cat);
}
