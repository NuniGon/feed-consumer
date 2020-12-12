package com.sparta.service.impl;

import com.sparta.model.dto.TotalRecordsDTO;
import com.sparta.service.DataProviderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DataProviderServiceImpl implements DataProviderService {


    @Override
    public TotalRecordsDTO getTotalRecords(String provider) {
        return null;
    }
}
