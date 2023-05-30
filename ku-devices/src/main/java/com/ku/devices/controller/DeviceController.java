package com.ku.devices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeviceController {

    @GetMapping("/data")
    public String getSimpleData() {
        return "Hello from Devices module!";
    }
}
