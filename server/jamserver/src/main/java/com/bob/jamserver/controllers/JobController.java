package com.bob.jamserver.controllers;

import com.bob.jamserver.model.Job;
import com.bob.jamserver.model.User;
import com.bob.jamserver.services.JobService;
import com.bob.jamserver.services.UserService;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class JobController{
	@Autowired
	JobService jobService;
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/customer", method=RequestMethod.POST)
	public Job getCustomerForJob(@RequestBody Job job) {
		
		System.out.println(job.getId());
		Job cust = jobService.findJobById(job.getId());

		return cust;
	}
	
	@RequestMapping(value="/completed", method = RequestMethod.POST)
	public  List<Job> jobCompleted(@RequestBody Job job) throws IOException {
		User user = job.getUser();
		String userEmail = user.getEmail();
		Long userId = user.getId();
		Long jobId = job.getId();
		String time = job.getTime();
		String jobDescription = job.getDescription();
	
		jobService.updateJob(jobId, time, jobDescription);
		jobService.emailConfirmation(userEmail,jobId,jobDescription);
		List<Job> completedJobs = jobService.jobsTodo(userId);
		return completedJobs;

	}
}