package com.blogging.blog.payloads;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDTO {
	private int id;
	@NotEmpty
	@Size(min=4,message="Name cannot be smaller than 4 letters ")
	private String name;
	
	@Email(message="Email is Invalid")
	private String email;
	
	@NotEmpty
	@Size(min=3,max=10,message="Password must be of 3 char and cannot be greater than 10")
	private String password;
	
	@NotEmpty
	private String about;

	}

