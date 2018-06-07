package com.bob.jamserver.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bob.jamserver.model.Window;
import com.bob.jamserver.repositories.WindowRepository;

@Service
public class WindowService {
	@Autowired
	WindowRepository windowRepo;
	
	public void createWindow (Window window) {
		windowRepo.save(window);
	}

}
