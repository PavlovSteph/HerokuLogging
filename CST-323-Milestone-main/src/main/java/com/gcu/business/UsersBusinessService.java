package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gcu.data.repository.UsersRepository;

@Service
public class UsersBusinessService implements UserDetailsService{

	// declare and initialize respository and logger
	@Autowired
	UsersRepository userRepository;
	private static final Log logger = LogFactory.getLog(UsersBusinessService.class);
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.info("Entering loadUserByUsername()");
		//Try to find the User in the database. If not found throw a User Not Found Exception else return a Spring Security User
		var user = userRepository.findByUsername(username);
		
		if(user == null)
		{
			logger.error("Exiting loadUserByUsername() with UserNotFoundException");
			throw new UsernameNotFoundException("Username not found: " + username);		
		}
		else
		{
			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			authorities.add(new SimpleGrantedAuthority("USER"));
			logger.info("Exiting loadUserByUsername() successfully");
			return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
		}
	}
}
