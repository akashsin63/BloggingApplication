package com.blogging.blog.reposetories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogging.blog.entites.Users;

public interface UserRepo extends JpaRepository<Users,Integer> {

}
