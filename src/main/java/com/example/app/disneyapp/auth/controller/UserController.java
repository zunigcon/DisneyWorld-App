package com.example.app.disneyapp.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.disneyapp.auth.dto.AuthenticationRequest;
import com.example.app.disneyapp.auth.dto.AuthenticationResponse;
import com.example.app.disneyapp.auth.dto.UserDTO;
import com.example.app.disneyapp.auth.service.JwtUtils;
import com.example.app.disneyapp.auth.service.UserDetailsCustomService;

@RestController
@RequestMapping("auth")
public class UserController {
	
	@Autowired
	private UserDetailsCustomService userDetailsService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtUtils jwtTokenUtil;
	
	@PostMapping("/register")
	public ResponseEntity<AuthenticationResponse> signUp(@RequestBody UserDTO userDTO) throws Exception{
		userDetailsService.save(userDTO);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@PostMapping("/login")
	public ResponseEntity<AuthenticationResponse> signIn(@RequestBody AuthenticationRequest authRequest) throws Exception{
		UserDetails userDetails;
		try {
			Authentication auth = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())	
			);
			userDetails = (UserDetails) auth.getPrincipal();
		} catch (BadCredentialsException e) {
			throw new Exception("Usuario o Contraseña incorrectos", e);
		}
		final String jwt = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
}
