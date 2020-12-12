package com.sparta.service;

import com.sparta.model.LoadBatch;

public interface DataProviderService {

    public LoadBatch getTotalRecords(String provider);
}
