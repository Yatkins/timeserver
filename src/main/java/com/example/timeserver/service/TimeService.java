package com.example.timeserver.service;

import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@Service
public class TimeService {

    //return gmt
    public String getTime(){
        Date date = new Date();
        return date.toString();
    }

    public String getGMT(){
        DateFormat dateFormat = new SimpleDateFormat();
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return dateFormat.format(dateFormat);
    }

    public Long getEpochTime() {
        Date date = new Date();
        return date.getTime();
    }

    public String getRequestedTimeZoneTime(String zone){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss:SSS'Z'ZZZ");
        dateFormat.setTimeZone(TimeZone.getTimeZone(zone));
        return dateFormat.format(dateFormat);
    }

}
