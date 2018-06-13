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

	public void updateDoor(Long id, String type,int hinges,int screws,double height,double width,String color
			,int quantity){

		Door door = doorRepo.findDoorById(id);

		door.setColor(color);
		door.setHeight(height);
		door.setHinges(hinges);
		door.setQuantity(quantity);
		door.setType(type);
		door.setWidth(width);
		door.setScrews(screws);

		doorRepo.save(door);
	}

}
