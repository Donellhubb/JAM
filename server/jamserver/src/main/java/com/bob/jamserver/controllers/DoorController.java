package com.bob.jamserver.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bob.jamserver.model.Door;
import com.bob.jamserver.services.DoorService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
public class DoorController {
   @Autowired
   DoorService doorService;
   
	@RequestMapping(value = "/door/create", method = RequestMethod.POST)
	public String createDoor(@RequestBody Door door) {
		doorService.createDoor(door);
		return "DoorSuccessfullyCreated";
		
	}

}
