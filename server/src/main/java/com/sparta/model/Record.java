package com.sparta.model;

import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
public class Record {

    private long id; // recordIndex;
    private Instant date;//long timestamp;
    private String city;
    // private int numberBytesSensorData;
    private List<Sensor> sensorsData;
    //private int crc32SensorsData;

}
