package com.bob.jamserver.controllers;

import com.bob.jamserver.model.Job;
import com.bob.jamserver.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin
@RestController
public class JobController{
	@Autowired
	JobService jobService;
	
	@RequestMapping(value="/customer", method=RequestMethod.POST)
	public Job getCustomerForJob(@RequestBody Job job) {
		
		System.out.println(job.getId());
		Job cust = jobService.findJobById(job.getId());

		return cust;
	}
	
	@RequestMapping(value="/completed", method = RequestMethod.POST)
	public  void jobCompleted(@RequestBody Job job) throws IOException {
		String userEmail = job.getUser().getEmail();
		Long jobId = job.getId();
		String time = job.getTime();
		String jobDescription = job.getDescription();
	
		jobService.updateJob(jobId, time, jobDescription);
		jobService.emailConfirmation(userEmail,jobId,jobDescription);

	}
}