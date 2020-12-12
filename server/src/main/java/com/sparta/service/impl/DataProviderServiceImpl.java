package com.sparta.service.impl;

import com.sparta.core.exceptions.SpartaNotFoundException;
import com.sparta.model.Record;
import com.sparta.model.dto.TotalRecordsDTO;
import com.sparta.model.dto.factory.TotalRecordsFactory;
import com.sparta.repository.ProviderRespository;
import com.sparta.service.DataProviderService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class DataProviderServiceImpl implements DataProviderService {


    private final ProviderRespository providerRespository;

    @Override
    public TotalRecordsDTO getTotalRecords(String provider) {
        List<Record> records = providerRespository.findByProvider(provider);

        if (records == null) {
            throw new SpartaNotFoundException(provider, Record.class.getName());
        }

        return TotalRecordsFactory.newInstance(records.size());
    }
}
