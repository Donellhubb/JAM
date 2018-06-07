package com.bob.jamserver.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bob.jamserver.model.Door;

@Repository
public interface DoorRepository extends CrudRepository<Door,Long> {
	List<Door> findAll();
}
