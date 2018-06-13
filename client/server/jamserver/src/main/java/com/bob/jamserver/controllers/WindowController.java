package com.bob.jamserver.controllers;

import com.bob.jamserver.model.Window;
import com.bob.jamserver.services.WindowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
<<<<<<< HEAD

=======
>>>>>>> 46c11d7ba4769a26d24e79c224a4bc1af0ef782e
@CrossOrigin
@RestController
public class WindowController {

    @Autowired
<<<<<<< HEAD
    WindowService  windowService;

    HashMap<String, List<Window>> windows = new HashMap<String, List<Window>>();

    @RequestMapping(value = "/window/create", method = RequestMethod.POST)
    public HashMap<String, List<Window>> createDoor(@RequestBody Window window) {
=======
    private WindowService windowService;

    private HashMap<String, List<Window>> windows = new HashMap<String, List<Window>>();

    @RequestMapping(value = "/window/create", method = RequestMethod.POST)

    public HashMap<String, List<Window>> createWindow(@RequestBody Window window) {
>>>>>>> 46c11d7ba4769a26d24e79c224a4bc1af0ef782e

        windowService.createWindow(window);
        windows.put("WindowCreatedSuccessfully",windowService.getWindowsForJob(window.getJob().getId()));

        return windows;
    }
<<<<<<< HEAD

    @RequestMapping(value="/edit/window",method=RequestMethod.POST)
    public String updateCabinet(@RequestBody Window window){
        windowService.updateWindow(window);
        return "windowUpdated";
    }


}
=======
}
>>>>>>> 46c11d7ba4769a26d24e79c224a4bc1af0ef782e
