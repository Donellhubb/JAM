package com.bob.jamserver.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bob.jamserver.model.Cabinet;
import com.bob.jamserver.repositories.CabinetRepository;

@Service 
public class CabinetService {
	
	@Autowired
	private CabinetRepository cabinetRepository;
	public CabinetService() {}
	
	public void createCabinet(Cabinet cabinet) {
		cabinetRepository.save(cabinet);
	}

}
