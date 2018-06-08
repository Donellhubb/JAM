package com.bob.jamserver.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bob.jamserver.model.Job;
import com.bob.jamserver.repositories.JobRepository;

@Service
public class JobService {
	
	@Autowired
	JobRepository jobRepo;
	
	public List<Job> findUserJobs(Long userId){
		return jobRepo.findJobsByUserId(userId);
		
	}
	
}
