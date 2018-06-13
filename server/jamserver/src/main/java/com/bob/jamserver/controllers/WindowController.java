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
    public String updateCabinet(@RequestBody Window window){
        windowService.updateWindow(window);
        return "windowUpdated";
    }


}
