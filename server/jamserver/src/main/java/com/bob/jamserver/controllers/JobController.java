package com.bob.jamserver.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bob.jamserver.model.Customer;
import com.bob.jamserver.model.Job;
import com.bob.jamserver.services.JobService;

@CrossOrigin
@RestController
public class JobController{
	@Autowired
	JobService jobService;
	
	@RequestMapping(value="/customer", method=RequestMethod.POST)
	public Customer getCustomerForJob(@RequestBody Job job) {
		System.out.println("in jobcontroller");
		System.out.println(job.getId());
		return jobService.getCustomer(job.getId());
	}
}