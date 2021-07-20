package com.khantwal.authentication.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.client.RestTemplate;

import com.khantwal.authentication.entities.Employee;


public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	RestTemplate restTemplate;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Employee employee = restTemplate
				.getForObject("http://EMPLOYEE-SERVICE/employee/getEmployeeByUserName/"+username,Employee.class);
		if(employee == null) {
			throw new UsernameNotFoundException("Could Not Found User");
		}
		
		CustomUserDetails customUserDetails = new CustomUserDetails(employee);
		return customUserDetails;
	}

}
