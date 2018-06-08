//package com.bob.jamserver.services;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.bob.jamserver.model.Job;
//import com.bob.jamserver.repositories.JobRepository;
//
//@Service
//public class JobServiceImpl implements JobService {
//	@Autowired
//	private JobRepository jobRepository;
//
//	@Override
//	public Iterable<Job> findAll() {
//		// TODO Auto-generated method stub
//	
//		return jobRepository.findAll();
//	}
//
//	@Override
//	public Job findOne(Long id) {
//		// TODO Auto-generated method stub
//		return jobRepository.findOne();
//	}
//
////	@Override---- this table does not have a complete job!
////	public void toggleComplete(Long id) {
////		// TODO Auto-generated method stub
////		
////		Job job = JobRepository.findOne(id);
////		job.setComplete(!job.isComplete)
////		
////	}
//
//	@Override
//	public void save(Job job) {
//		// TODO Auto-generated method stub
//		jobRepository.save(job);
//		
//	}
//
//}
