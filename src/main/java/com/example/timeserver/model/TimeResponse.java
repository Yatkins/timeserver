package com.example.timeserver.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //adds getters and setters
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TimeResponse {

    private Long epochMillis;
    private String utcTime;
    private String localTime;

}
