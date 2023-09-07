package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repository.ResgisterUserRepository;
import com.example.demo.entity.RegisterUser;

@RestController
public class RegisterController {
@Autowired
ResgisterUserRepository resgisterUserRepository;


@Autowired
BCryptPasswordEncoder passwordEncoder; 

@PostMapping("/register")
public RegisterUser registerUser(@RequestBody RegisterUser user) {
	user.setPassword(passwordEncoder.encode(user.getPassword()));
	resgisterUserRepository.save(user);
	return user;
}

}
