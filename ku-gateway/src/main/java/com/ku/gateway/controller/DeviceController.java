package com.ku.gateway.controller;

import com.ku.gateway.service.DeviceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Devices", description = "Device information")
@RequestMapping("/devices")
public class DeviceController {

    private DeviceService deviceService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Find device")
    public String findDevice() {
        return deviceService.getObject();
    }

    @Autowired
    public void setCompanyService(DeviceService deviceService) {
        this.deviceService = deviceService;
    }
}
