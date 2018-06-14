package com.bob.jamserver.repositories;

import com.bob.jamserver.model.Cabinet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CabinetRepository extends CrudRepository<Cabinet, Long> {
	List<Cabinet> findAll();
	List<Cabinet> findByJobIdOrderByIdDesc(Long Id);
	Cabinet findCabinetById(Long id);
	void deleteById(Long id);

}
