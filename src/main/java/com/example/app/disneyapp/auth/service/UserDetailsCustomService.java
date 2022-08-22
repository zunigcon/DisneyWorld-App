package com.example.app.disneyapp.auth.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.app.disneyapp.auth.dto.UserDTO;
import com.example.app.disneyapp.auth.entity.UserEntity;
import com.example.app.disneyapp.auth.repository.UserRepository;

@Service
public class UserDetailsCustomService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity user = userRepository.findByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException("Usuario o Contraseña no Encontrada");
		}
		return new User(user.getUsername(), user.getPassword(), Collections.emptyList());
	}
	
	public boolean save(UserDTO userDTO) {
		UserEntity userEntity = new UserEntity(userDTO.getUsername(),userDTO.getPassword());
		userEntity = userRepository.save(userEntity);
		return userEntity!=null;
	}

}
