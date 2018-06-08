//package com.bob.jamserver.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.bob.jamserver.model.Job;
//import com.bob.jamserver.repositories.JobRepository;
//import com.bob.jamserver.services.JobService;
//@Service
//public class SecurityConfig implements JobService {
//	@SuppressWarnings("unchecked")
//	@Autowired 
//	private JobRepository jobRepository;
//	@Override
//	public Iterable<Job> findAll() {
//		// TODO Auto-generated method stub
//		return jobRepository.findAll();
//	}
//
//	@Override
//	public Job findOne(Long id) {
//		// TODO Auto-generated method stub
//		return jobRepository.findOne(id);
//	
//	}
//
//	@Override
//	public void toggleComplete(Long id) {
//		// TODO Auto-generated method stub
//		Job job = jobRepository.findOne(id);
//		job.setComplete(!Job.isComplete());
//		jobRepository.save(job);
//		
//	}
//
//	@Override
//	public void save(Job job) {
//		// TODO Auto-generated method stub
//		jobRepository.save(job);
//		
//	}
//	
//	
//
//}
