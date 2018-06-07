package com.bob.jamserver.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bob.jamserver.model.Door;
import com.bob.jamserver.repositories.DoorRepository;

@Service
public class DoorService {
	@Autowired
	DoorRepository doorRepo;
	
	public void createDoor(Door door) {
		doorRepo.save(door);
	}

}
