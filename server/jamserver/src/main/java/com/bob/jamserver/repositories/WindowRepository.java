package com.bob.jamserver.repositories;

import com.bob.jamserver.model.Window;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository


public interface WindowRepository extends CrudRepository<Window,Long> {
	List<Window> findAll();
	List<Window>  findByJobIdOrderByIdDesc(Long id);
	Window findWindowById(Long id);
	void deleteById(Long id);


}
