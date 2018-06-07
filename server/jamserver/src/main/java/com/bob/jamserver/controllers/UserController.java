package com.bob.jamserver.controllers;

import com.bob.jamserver.model.Job;
import com.bob.jamserver.model.User;
import com.bob.jamserver.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



@CrossOrigin(origins="http://localhost:3000")
@RestController
public class UserController {
	HashMap<String,String> data = new HashMap<String,String>();
	HashMap<String ,List<Job>> UserJobs = new HashMap<String ,List<Job>>();
	List<String> message = new ArrayList<String>();
	@Autowired
	private UserService userService;
	
	@RequestMapping("/register")
	public String userSign(@Valid @RequestBody User user, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println(result);
			return "Unsuccessful";
		}
		userService.saveUser(user);
		return "registerSuccess";
	}
	
	@RequestMapping("/login")
	public HashMap<String,String> userLogin(@Valid @RequestBody User user, BindingResult result) {
		System.out.println("in login bitschess");
		if(result.hasErrors()) {
			data.put("msg","error");
			return data;
		}
		System.out.println(user.getPassword());
		if(userService.checkEmailExists(user.getEmail())){
				if(userService.authenticateUser(user.getEmail(),user.getPassword())) {
					String token = userService.updateToken(user.getEmail());
					
					data.put("token",token);
					
					data.put("msg", "LoginSuccessful" );
					return data;
				}else {
			
					data.put("msg","WrongPassword" );
					return data;
				}
		}else {
			data.put("msg","EmailDoesNotExist" );
			return data;
		}
			
		
	}

	@RequestMapping(value="/jobs",method=RequestMethod.POST)
	public List<Job>  userJobs(@RequestBody User user) {
		List<Job> empty = new ArrayList<Job>();
		if (data.containsValue(user.getToken())) {
			User empl = userService.findByToken(user.getToken());
//			System.out.println("");
			return empl.getJobs();
		}
		return empty;
	}
}
