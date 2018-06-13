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
	public String updateCabinet(@RequestBody Door door){
		doorService.updateDoor(door);
		return "doorUpdated";
	}


}
