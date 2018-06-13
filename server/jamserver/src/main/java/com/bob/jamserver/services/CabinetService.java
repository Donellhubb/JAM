package com.bob.jamserver.services;

import com.bob.jamserver.model.Cabinet;
import com.bob.jamserver.repositories.CabinetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service 
public class CabinetService {
	
	@Autowired
	private CabinetRepository cabinetRepository;
	public CabinetService() {}
	
	public void createCabinet(Cabinet cabinet) {
		cabinetRepository.save(cabinet);
	}


	public void updateCabinet(Long id,String type,int hinges,int screws,int quantity,double height
			,double width,String color){

		Cabinet cabinet = cabinetRepository.findCabinetById(id);
		cabinet.setColor(color);
		cabinet.setHeight(height);
		cabinet.setType(type);
		cabinet.setHinges(hinges);
		cabinet.setQuantity(quantity);
		cabinet.setWidth(width);
		cabinet.setScrews(screws);
		cabinetRepository.save(cabinet);
	}

	public List<Cabinet> getCabinetsForJob(Long jobId){
		return cabinetRepository.findByJobIdOrderByIdDesc(jobId);

	}


}
