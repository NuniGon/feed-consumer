package com.sparta.service;

import com.sparta.model.dto.TotalRecordsDTO;

public interface DataProviderService {

    public TotalRecordsDTO getTotalRecords(String provider);
}
