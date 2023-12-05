package com.blogging.blog.reposetories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogging.blog.entites.Category;

public interface CategoryRepo extends JpaRepository<Category,Integer> {

}
