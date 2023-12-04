package com.blogging.blog.payloads;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
public class CategoryDTO {
	private Integer categoryId;
	
	@NotEmpty
	@Size(min=6)
	private String discription;
	
	@NotEmpty
	@Size(min=1)
	private String title;
	
}
