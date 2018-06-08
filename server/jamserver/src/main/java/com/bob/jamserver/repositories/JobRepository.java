package com.bob.jamserver.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bob.jamserver.model.Customer;
import com.bob.jamserver.model.Job;


@Repository

public interface JobRepository extends CrudRepository<Job, Long>{
//	@Query("select j from Job j where j.user.id=#{principal.id}")
	    List<Job> findAll();
	    List<Job> findJobsByUserId(Long id);
	    List<Job> findJobsByCustomerId(Long id);
	    Customer findCustomerById(Long id);


	
}
