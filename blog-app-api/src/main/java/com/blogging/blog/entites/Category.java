package com.blogging.blog.entites;

import java.util.ArrayList;
import java.util.List;

import org.springframework.aot.generate.GeneratedTypeReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;
import lombok.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name="categories")
public class Category {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer categoryId;
		
		@Column(name="title",length = 100,nullable = false)
		private String categoryTitle;
		
		@Column(name="description")
		private String categoryDescription;
		
		@OneToMany(mappedBy = "category",cascade=CascadeType.ALL)
		private List<Post> post = new ArrayList<>();
}
