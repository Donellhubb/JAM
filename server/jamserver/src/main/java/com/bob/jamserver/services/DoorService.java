package com.bob.jamserver.services;

import com.bob.jamserver.model.Door;
import com.bob.jamserver.repositories.DoorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoorService {
	@Autowired
	DoorRepository doorRepo;
	
	public void createDoor(Door door) {
		doorRepo.save(door);

	}

	public List<Door> getDoorsForJob(Long jobId){
		return  doorRepo.findDoorsByJobID(jobId);
	}

}
