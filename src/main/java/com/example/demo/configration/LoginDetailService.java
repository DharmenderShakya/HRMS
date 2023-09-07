package com.example.demo.configration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.ResgisterUserRepository;
import com.example.demo.entity.RegisterUser;

@Service
public class LoginDetailService implements UserDetailsService {
	
	@Autowired
	ResgisterUserRepository resgisterUserRepository ;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		RegisterUser user=resgisterUserRepository.findByName(username);
		System.out.println("--------------------------"+user.getName());
		
		if (user.getName()==null) {
			new UsernameNotFoundException("user not found");
		}
			LoginDetails loginDetails=new LoginDetails(user);
			
		 return loginDetails;
	}
	
}
