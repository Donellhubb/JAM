package com.bob.jamserver.services;

import com.bob.jamserver.model.User;
import com.bob.jamserver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;


@Service
public class UserService {
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	@Autowired 
	private UserRepository userRepo;
	
	public void saveUser(User user) {
		user.setPassword(bcrypt.encode(user.getPassword()));
		System.out.println(user.getEmail());
		userRepo.save(user);
		
	}
	  
	public boolean checkEmailExists(String email) {
		if(userRepo.findByEmail( email)!= null) {
			User userFound = userRepo.findByEmail(email);
			return true;

			
		}else {
			return false;
		}
	}
	
	public boolean authenticateUser(String email,String pwd) {
		User userFound = userRepo.findByEmail(email);
		System.out.println("in service password "+userFound.getPassword());
		if(bcrypt.matches(pwd, userFound.getPassword())){
			return true;
		}else {
			return false;
		}
	}
	
	public String generateToken() {
		SecureRandom random = new SecureRandom();
	    byte bytes[] = new byte[20];
	    random.nextBytes(bytes);
	    String st = "";
	    for(int i = 0; i < bytes.length;i++) {
	    	st+=bytes[i];
	    }

    return st;
	}
	
	public String updateToken(String email) {
	 User user = userRepo.findByEmail(email);
	 String token = generateToken();
	 user.setToken(token);
	 userRepo.save(user);
	 System.out.println("in update token "+ token);
	 return token;
	}
	
	public User findByToken(String token){
		User user = userRepo.findByToken(token);
		return user;
	}

}
