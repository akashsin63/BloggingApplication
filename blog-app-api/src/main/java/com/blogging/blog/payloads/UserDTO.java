package com.blogging.blog.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDTO {
	private int id;
	@NotNull
	private String name;
	private String email;
	private String password;
	private String about;
}
