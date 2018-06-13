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

	public void updateDoor(Door door){
		 String type = door.getType();
		 int hinges = door.getHinges();
		 int screws = door.getScrews();
		 double height = door.getHeight();
		 double width = door.getWidth();
		String color = door.getColor();
		int quantity = door.getQuantity();


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
