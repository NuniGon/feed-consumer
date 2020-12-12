package com.sparta.model;

import lombok.Data;

import java.util.List;

@Data
public class LoadBatch {

    private long total;

    private List<Record> records;

}
