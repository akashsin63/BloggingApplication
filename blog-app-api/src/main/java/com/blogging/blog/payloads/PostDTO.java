package com.blogging.blog.payloads;

import java.util.Date;

import com.blogging.blog.entites.Category;
import com.blogging.blog.entites.Users;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class PostDTO {
	private String title;
	
	private String content;
	
	private String imageName;
	
	private Date addedDate;
	
	private Category category;
	
	private Users user;
	
	
	
}
