package com.happy.workplace.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.happy.workplace.entity.Login;
import com.happy.workplace.entity.Users;
import com.happy.workplace.exception.ResourceNotFoundException;
import com.happy.workplace.repository.UserRepository;

@Service
@Transactional
public class UserService {
	
	private UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public Users login(Login login) throws ResourceNotFoundException {
		String email = login.getEmailId();
		System.out.println("Inside login");
		List<Users> user = userRepository.findByEmailAndPassword(login.getEmailId(), login.getPassword());
		
		System.out.println("User is: "+user.toString());
		if(user.size()==0) {
			System.out.println("Invalid user");
			throw new ResourceNotFoundException("User not found for this id: " + email);
		}
					
		return user.get(0);
	}
	
}
