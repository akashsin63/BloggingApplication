package com.blogging.blog.services.impl;
import com.blogging.blog.reposetories.*;
import com.blogging.blog.execptions.ResourceNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogging.blog.entites.Users;
import com.blogging.blog.payloads.UserDTO;
import com.blogging.blog.reposetories.UserRepo;
import com.blogging.blog.services.UserService;


@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo userRepo;
	
	
	@Autowired
	private ModelMapper modelmapper;
	
	
	@Override
	public UserDTO createUser(UserDTO userDTO) {
	    Users user = this.dtoToUser(userDTO);
	    Users savedUser = this.userRepo.save(user);
	    return this.userToDTO(savedUser);
	}


	@Override
	public UserDTO updateUser(UserDTO userDTO , Integer userId) {
		Users user = this.userRepo.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("User" , "id" ,userId));
	    user.setName(userDTO.getName());
		user.setEmail(userDTO.getEmail());
		user.setPassword(userDTO.getPassword());
		user.setAbout(userDTO.getAbout());
		
		Users updatedUser = this.userRepo.save(user);
		UserDTO userDto1 = this.userToDTO(updatedUser);
		
		return userDto1;
	}

	@Override
	public UserDTO getUserById(Integer userId) {
		Users user = this.userRepo.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("User" , "id" ,userId));
		
		
		return this.userToDTO(user);
	}

	@Override
	public List<UserDTO> getAllUsers() {
		List<Users> users = this.userRepo.findAll();
		
		List<UserDTO> userDTO = users.stream().map(user->this.userToDTO(user)).collect(Collectors.toList());
		return userDTO;
	}

	@Override
	public void deleteUser(Integer userId) {
		Users user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User" , "id", userId));
		this.userRepo.delete(user);
	}
	
	//this method is similar to model mapper library
	private Users dtoToUser(UserDTO userDTO) {
		Users user = this.modelmapper.map(userDTO, Users.class);
				
//		user.setId(userDTO.getId());
//		user.setName(userDTO.getName());
//		user.setEmail(userDTO.getEmail());
//		user.setPassword(userDTO.getPassword());
//		user.setAbout(userDTO.getAbout());
//		
		return user;
	}
	public UserDTO userToDTO(Users user) {
		UserDTO userDTO = this.modelmapper.map(user, UserDTO.class);
		
//		userDTO.setId(user.getId());
//		userDTO.setName(user.getName());
//		userDTO.setEmail(user.getEmail());
//		userDTO.setPassword(user.getPassword());
//		userDTO.setAbout(user.getAbout());
//		
		return userDTO;
	}
}
