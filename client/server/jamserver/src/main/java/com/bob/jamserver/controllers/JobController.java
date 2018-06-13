package com.bob.jamserver.controllers;

import com.bob.jamserver.model.Job;
import com.bob.jamserver.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class JobController{
	@Autowired
	JobService jobService;
	
	@RequestMapping(value="/customer", method=RequestMethod.POST)
	public Job getCustomerForJob(@RequestBody Job job) {
		System.out.println("in jobcontroller");
		System.out.println(job);
		System.out.println(job.getId());
		Job cust = jobService.findJobById(job.getId());

		return cust;
	}
}