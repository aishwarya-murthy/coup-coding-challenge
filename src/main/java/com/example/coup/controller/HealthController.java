package com.example.coup.controller;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/coup-api")
public class HealthController {

    @ApiOperation("Check health")
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/health")
    public String health() {
        return "ok";
    }
}
