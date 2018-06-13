package com.bob.jamserver.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bob.jamserver.model.Cabinet;
import com.bob.jamserver.services.CabinetService;

import java.util.HashMap;
import java.util.List;

@CrossOrigin
@RestController
public class CabinetController {
	
	@Autowired
	private CabinetService cabinetService;

	private HashMap<String,List<Cabinet>> cabinets = new HashMap<String, List<Cabinet>>();

	@RequestMapping(value = "/cabinet/create", method = RequestMethod.POST)

	public HashMap<String, List<Cabinet>> createCabinet(@RequestBody Cabinet cabinet) {

		cabinetService.createCabinet(cabinet);
		cabinets.put("CabinetCreatedSuccessfully",cabinetService.getCabinetsForJob(cabinet.getJob().getId()));
		return cabinets ;
	}

	@RequestMapping(value="/edit/cabinet",method=RequestMethod.POST)
	public String updateCabinet(@RequestBody Cabinet cabinet){
		String type = cabinet.getType();
		int hinges = cabinet.getHinges();
		int screws = cabinet.getScrews();
		int quantity = cabinet.getQuantity();
		double height = cabinet.getHeight();
		double width = cabinet.getWidth();
		String color = cabinet.getColor();
		cabinetService.updateCabinet(cabinet.getId(),type,hinges,screws,quantity,height,width,color);

		return "cabinetUpdated";
	}

}
