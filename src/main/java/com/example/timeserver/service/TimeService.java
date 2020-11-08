package com.example.timeserver.service;

import com.example.timeserver.model.TimeResponse;
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

    public Long getEpochTime() {
        Date date = new Date();
        return date.getTime();
    }

    public String getTimeZoneTime(String zone){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss:SSS'Z'ZZZ");
        dateFormat.setTimeZone(TimeZone.getTimeZone(zone));
        return dateFormat.format(new Date());
    }

    public TimeResponse getTimeResponse(){
        Date date = new Date();
        return TimeResponse.builder()
                .localTime(date.toString())
                .epochMillis(date.getTime())
                .utcTime(getUtcDateFromLocalDate(date))
                .build();
    }

    private String getUtcDateFromLocalDate(Date date) {
        TimeZone zone = TimeZone.getTimeZone("UTC");
        DateFormat dateFormat = new SimpleDateFormat();
        dateFormat.setTimeZone(zone);
        return dateFormat.format(date);
    }

}
