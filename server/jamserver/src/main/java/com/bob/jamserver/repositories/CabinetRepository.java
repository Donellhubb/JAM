package com.bob.jamserver.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bob.jamserver.model.Cabinet;

@Repository
public interface CabinetRepository extends CrudRepository<Cabinet, Long> {
	
	

}
