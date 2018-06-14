package com.bob.jamserver.controllers;

import com.bob.jamserver.model.Door;
import com.bob.jamserver.services.DoorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@CrossOrigin
@RestController
public class DoorController {
   @Autowired
   DoorService doorService;

   HashMap<String, List<Door>> doors = new HashMap<String, List<Door>>();
   
	@RequestMapping(value = "/door/create", method = RequestMethod.POST)
	public HashMap<String, List<Door>> createDoor(@RequestBody Door door) {

		doorService.createDoor(door);
		doors.put("DoorCreatedSuccessfully",doorService.getDoorsForJob(door.getJob().getId()));

		return doors;
	}

	@RequestMapping(value="/edit/door",method=RequestMethod.POST)
	public HashMap<String, List<Door>> updateDoor(@RequestBody Door door){
		String type = door.getType();
		int hinges = door.getHinges();
		int screws = door.getScrews();
		double height = door.getHeight();
		double width = door.getWidth();
		String color = door.getColor();
		int quantity = door.getQuantity();


		Long jobId = door.getJob().getId();

		doorService.updateDoor(door.getId(),type,hinges,screws,height,width,color,quantity);
		List<Door> Jobdoors = doorService.getDoorsForJob(jobId);
		doors.put("DoorCreatedSuccessfully",Jobdoors );
		return doors;
	}

	@RequestMapping(value="/delete/door", method=RequestMethod.POST)
	public HashMap<String, List<Door>> deleteDoor(@RequestBody Door door) {
		Long jobId = door.getJob().getId();
		doorService.deleteDoor(door.getId());
		List<Door> Jobdoors = doorService.getDoorsForJob(jobId);
		doors.put("DoorCreatedSuccessfully",Jobdoors );
		return doors;
	}


}
