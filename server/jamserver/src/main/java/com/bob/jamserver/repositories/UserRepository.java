package com.bob.jamserver.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bob.jamserver.model.Job;
import com.bob.jamserver.model.User;

@Repository
public interface UserRepository extends CrudRepository<User , Long> {
	User findByEmail(String email);
	User findByToken(String token);
	
}
