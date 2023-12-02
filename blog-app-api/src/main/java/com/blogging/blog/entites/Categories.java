package com.blogging.blog.entites;

import org.springframework.aot.generate.GeneratedTypeReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;
import lombok.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Categories {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer categoryId;
	
	@Column(name="discription",length=100,nullable=false)
	private String categoryDescription;
	
	@Column(name="title")
	private String categoryTitle;
	
	
}
