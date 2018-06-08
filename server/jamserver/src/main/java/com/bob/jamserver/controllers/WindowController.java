package com.bob.jamserver.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bob.jamserver.model.Window;
import com.bob.jamserver.services.WindowService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
public class WindowController {
   @Autowired
   WindowService windowService;
   
	@RequestMapping(value = "/window/create", method = RequestMethod.POST)
	public String createDoor(@RequestBody Window window) {
		windowService.createWindow(window);
		return "WindowSuccessfullyCreated";
		
	}

}