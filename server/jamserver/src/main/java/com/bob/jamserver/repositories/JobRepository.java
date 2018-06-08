package com.bob.jamserver.repositories;

import com.bob.jamserver.model.Customer;
import com.bob.jamserver.model.Job;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository

public interface JobRepository extends CrudRepository<Job, Long>{
//	@Query("select j from Job j where j.user.id=#{principal.id}")
	    List<Job> findAll();
	    Job findJobById(Long id);
	    List<Job> findJobsByUserId(Long id);
	    List<Job> findJobsByCustomerId(Long id);
	    Customer findCustomerById(Long id);


	
}
