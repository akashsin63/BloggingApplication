package com.blogging.blog.reposetories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogging.blog.entites.Categories;

public interface CategoryRepo extends JpaRepository<Categories,Integer> {

}
