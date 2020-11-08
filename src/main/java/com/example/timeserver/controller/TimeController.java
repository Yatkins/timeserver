package com.example.timeserver.controller;

import com.example.timeserver.model.TimeResponse;
import com.example.timeserver.service.TimeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class TimeController {

    private final TimeService timeService;

    public TimeController(TimeService timeService){
        this.timeService = timeService;
    }

    @GetMapping("/time")
    public String getTime(){
        return timeService.getTime();
    }

    @GetMapping("/epochTime")
    public Long getEpochTime(){
        return timeService.getEpochTime();
    }

    @GetMapping("/GMT")
    public String getGMT(){
        return timeService.getTimeZoneTime("utc");
    }

    @GetMapping("/getTime")
    public TimeResponse getTimeResponse(){
        return timeService.getTimeResponse();
    }


    @GetMapping("/requestedTimeZoneTime/{zone}")
    public String getRequestedTimeZoneTime(@PathVariable(value = "zone") String timeZone){
        return timeService.getTimeZoneTime(timeZone);
    }

}