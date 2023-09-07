package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repository.ResgisterUserRepository;
import com.example.demo.entity.RegisterUser;
import com.example.demo.request.Login;


@RestController
@RequestMapping("/auth")
public class LoginController {
	
	@Autowired
	ResgisterUserRepository resgisterUserRepository;

	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping("/authenticate")
	public String generateToken(@RequestBody Login login) {
		RegisterUser user=resgisterUserRepository.findByName(login.getName());
		System.out.println("generate token"+user.getName());
		System.out.println(login.getPassword());
		Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.getName(), login.getPassword()));
			if(authenticate.isAuthenticated())
			{
				
//				 String generateToken = jwtService.generateToken(login.getUsername());
				 String username=login.getName();
//				 String role=this.userService.roles(username);	
				
//				 List<Map<String,Object>> navs=this.accessTypesRepo.getAllUrl(role);
						 
				 return "login succesfully";
			
			}else 
			   {
				 throw new UsernameNotFoundException("invalid user request !!!");
			   }
		   
	         }
}
