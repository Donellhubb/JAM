package com.bob.jamserver.services;

import com.bob.jamserver.model.Window;
import com.bob.jamserver.repositories.WindowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WindowService {
    @Autowired
    private WindowRepository windowRepository;

    public void createWindow(Window window){
        windowRepository.save(window);
    }

    public List<Window> getWindowsForJob(Long jobId){
        return  windowRepository.findWindowsByJobId(jobId);
    }

    public void updateWindow(Window window){

        String type = window.getType();
        double height = window.getHeight();
         double width = window.getWidth();
         int quantity = window.getQuantity();
        String color = window.getColor();

        window.setColor(color);
        window.setHeight(height);
        window.setQuantity(quantity);
        window.setWidth(width);
        window.setType(type);
        windowRepository.save(window);
    }
}
