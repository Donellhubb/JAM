package com.bob.jamserver.controllers;

import java.util.HashMap;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bob.jamserver.model.User;
import com.bob.jamserver.services.UserService;



@CrossOrigin(origins="http://localhost:3000")
@RestController
public class UserController {
	HashMap<String,String> data = new HashMap<String,String>();
	@Autowired
	private UserService userService;
	
	@RequestMapping("/signup")
	public String userSign(@Valid @RequestBody User user,BindingResult result) {
		if(result.hasErrors()) {
			System.out.println(result);
			return "Unsuccessful";
		}
		userService.saveUser(user);
		return "Signupsuccessful";
	}
	
	@RequestMapping("/login")
	public HashMap<String,String> userLogin(@Valid @RequestBody User user, BindingResult result) {
		if(result.hasErrors()) {
			data.put("msg","error");
			return data;
		}
		System.out.println(user.getPassword());
		if(userService.checkEmailExists(user.getEmail())){
				if(userService.authenticateUser(user.getEmail(),user.getPassword())) {
					userService.generateToken();
					data.put("token",userService.generateToken());
					data.put("msg", "LoginSuccessful" );
					return data;
				}else {
					data.clear();
					data.put("msg","WrongPassword" );
					return data;
				}
		}else {
			data.put("msg","EmailDoeNotExist" );
			return data;
		}
			
		
	}

}
