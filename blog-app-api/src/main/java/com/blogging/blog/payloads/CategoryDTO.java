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
	
	@NotBlank
	@Size(min=10,message = "minimium size of discription is 4")
	private String discription;
	
	@NotBlank
	@Size(min=4, message = "minimum size of title is 4")
	private String title;
	
}
