package com.example.coup.controller;

import com.example.coup.request.RequiredFleetEngineersRequest;
import com.example.coup.service.MaintenanceService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequestMapping(path = "/coup-api", produces = APPLICATION_JSON_UTF8_VALUE)
public class MaintenanceController {

    private final MaintenanceService maintenanceService;

    @Autowired
    public MaintenanceController(MaintenanceService maintenanceService) {
        this.maintenanceService = maintenanceService;
    }

    @ApiOperation("Returns minimum number of required fleet engineers")
    @ResponseBody
    @PostMapping(path = "/fleet-engineers-required", consumes = APPLICATION_JSON_UTF8_VALUE)
    public String findNumberOfFleetEngineers(@Valid @RequestBody RequiredFleetEngineersRequest request) {

        int numberOfEngineersRequired = maintenanceService.findMinimumRequiredFleetEngineers(request.getScooters(), request.getC(), request.getP());

        return "{ fleet_engineers: " + numberOfEngineersRequired + "}";

    }

}
