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
        return  windowRepository.findByJobIdOrderByIdDesc(jobId);
    }

    public void updateWindow(Long id,String type,double height,double width,int quantity,String color){
        Window windowToUpdate = windowRepository.findWindowById(id);

        windowToUpdate.setColor(color);
        windowToUpdate.setHeight(height);
        windowToUpdate.setQuantity(quantity);
        windowToUpdate.setWidth(width);
        windowToUpdate.setType(type);

        windowRepository.save(windowToUpdate);
    }

    public void deleteWindow(Long windowId) {
        windowRepository.deleteById(windowId);
    }
}
