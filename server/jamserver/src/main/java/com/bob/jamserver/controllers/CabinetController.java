package com.bob.jamserver.controllers;

import com.bob.jamserver.model.Cabinet;
import com.bob.jamserver.services.CabinetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin(origins= "http://localhost:3000")
@RestController
public class CabinetController {
	
	@Autowired
	private CabinetService cabinetService;
	
	@RequestMapping(value = "/cabinet/create", method = RequestMethod.POST)
	public String createCabinet(@RequestBody Cabinet cabinet) {
		cabinetService.createCabinet(cabinet);
		return "CabinetCreatedSuccessfully";
	}

}
