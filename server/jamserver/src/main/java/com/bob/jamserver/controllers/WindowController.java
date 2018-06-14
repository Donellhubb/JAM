package com.bob.jamserver.controllers;

import com.bob.jamserver.model.Window;
import com.bob.jamserver.services.WindowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@CrossOrigin
@RestController
public class WindowController {

    @Autowired

    WindowService  windowService;

    HashMap<String, List<Window>> windows = new HashMap<String, List<Window>>();

    @RequestMapping(value = "/window/create", method = RequestMethod.POST)
    public HashMap<String, List<Window>> createDoor(@RequestBody Window window) {


        windowService.createWindow(window);
        windows.put("WindowCreatedSuccessfully",windowService.getWindowsForJob(window.getJob().getId()));

        return windows;
    }

    @RequestMapping(value="/edit/window",method=RequestMethod.POST)
    public HashMap<String, List<Window>> updateWindow(@RequestBody Window window){
        String type = window.getType();
        double height = window.getHeight();
        double width = window.getWidth();
        int quantity = window.getQuantity();
        String color = window.getColor();

        Long jobId = window.getJob().getId();
        windowService.updateWindow(window.getId(),type,height,width,quantity,color);
        List<Window> JobWindows = windowService.getWindowsForJob(jobId);
       
        windows.put("WindowCreatedSuccessfully", JobWindows);

        return windows;
    }
    @RequestMapping(value="/delete/window", method=RequestMethod.POST)
    public HashMap<String,List<Window>> deleteWindow(@RequestBody Window window) {
        Long jobId = window.getJob().getId();
       
        windowService.deleteWindow(window.getId());
       
        List<Window> JobWindows = windowService.getWindowsForJob(jobId);
       
        windows.put("WindowCreatedSuccessfully", JobWindows);
        return windows;
    }



}

