package com.bob.jamserver.repositories;

import com.bob.jamserver.model.Door;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoorRepository extends CrudRepository<Door,Long> {
	List<Door> findAll();
	List<Door> findByJobIdOrderByIdDesc(Long id);
	Door findDoorById(Long id);
	void deleteById(Long id);


}
