package com.bob.jamserver.controllers;

import com.bob.jamserver.model.Job;
import com.bob.jamserver.model.User;
import com.bob.jamserver.services.JobService;
import com.bob.jamserver.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
public class JobController{
	@Autowired
	JobService jobService;
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/customer", method=RequestMethod.POST)
	public Job getCustomerForJob(@RequestBody Job job) {
		
//		System.out.println(job.getId());
		Job cust = jobService.findJobById(job.getId());

		return cust;
	}
	
	@RequestMapping(value="/completed", method = RequestMethod.POST)
	public  void jobCompleted(@RequestBody Job job) throws IOException {
		User user = job.getUser();
		System.out.println("is user passing "+job.getUser());
		String userEmail = user.getEmail();
		Long userId = user.getId();
		System.out.println("Can i get userId "+ userId);
//		Job job = jobService.findJobById(job.);
		Long jobId = job.getId();
		System.out.println("is job null "+jobId);
		Date time = job.getTime();
		String jobDescription = job.getDescription();
		System.out.println("job desc"+ jobDescription);
		jobService.updateJob(jobId,jobDescription);
		System.out.println(userEmail);
		jobService.emailConfirmation(userEmail,jobId,jobDescription);
		List<Job> uncompletedJobs = jobService.jobsTodo(userId);


	}
}