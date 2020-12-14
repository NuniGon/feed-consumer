package com.sparta.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Record {

    private long id; // recordIndex;
    private long timestamp;
    private String city;
    //private int numberBytesSensorData;
    private List<Sensor> sensorsData;
    //private long crc32SensorsData;

}
