package com.bob.jamserver.controllers;

import com.bob.jamserver.model.Job;
import com.bob.jamserver.model.User;
import com.bob.jamserver.services.JobService;
import com.bob.jamserver.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



@CrossOrigin
@RestController
public class UserController {
	HashMap<String,String> data = new HashMap<String,String>();
	
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private JobService jobService;

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
		System.out.println("in login ");
		if(result.hasErrors()) {
			data.put("msg","error");
			return data;
		}
		System.out.println(user.getPassword());
		if(userService.checkEmailExists(user.getEmail())){
			if(userService.authenticateUser(user.getEmail(),user.getPassword())) {
				String token = userService.updateToken(user.getEmail());
				System.out.println("user exists");
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
	public  List<Job> userJobs(@RequestBody User user) {
		List<Job> empty = new ArrayList<Job>();
		if (data.containsValue(user.getToken())) {
			User empl = userService.findByToken(user.getToken());
			empl.getId();
			jobService.findUserJobs(empl.getId());
			System.out.println("successful ");
			return jobService.findUserJobs(empl.getId());
		}
		return empty;
	}

}
