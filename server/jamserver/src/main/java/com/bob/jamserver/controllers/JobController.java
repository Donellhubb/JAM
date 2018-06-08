//package com.bob.jamserver.controllers;
//
//import java.security.Principal;
//
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.bob.jamserver.model.Job;
//import com.bob.jamserver.model.User;
//import com.bob.jamserver.services.JobService;
//
//@CrossOrigin(origins="htt://localhost:3000")
//@RestController
//public class JobController {
//	@RequestMapping(path= "/jobs", method=RequestMethod.POST)
//	public String addJob(@ModelAttribute Job job, Principal principal) {
//	User user = (User)((UsernamePasswordAuthenticationToken)principal).getPrincipal();
//	job.setUser(user);
//	JobService.save(job);
//	return "redirect:/";
//	}
// }
