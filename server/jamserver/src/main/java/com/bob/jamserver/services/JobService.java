package com.bob.jamserver.services;

import com.bob.jamserver.model.Customer;
import com.bob.jamserver.model.Job;
import com.bob.jamserver.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
	
	@Autowired
	JobRepository jobRepo;

	public void createJob(Job job){
		jobRepo.save(job);
	}
	
	public List<Job> findUserJobs(Long userId){
		return jobRepo.findJobsByUserId(userId);
		
	}
	public Job findJobById(Long id){
		return jobRepo.findJobById(id);
	}
	
	public Customer getCustomer(Long jobId) {
		return jobRepo.findCustomerById(jobId);
	}
	
}
