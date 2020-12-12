package com.sparta.service.impl;

import com.sparta.core.exceptions.SpartaNotFoundException;
import com.sparta.model.LoadBatch;
import com.sparta.repository.ProviderRespository;
import com.sparta.service.DataProviderService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class DataProviderServiceImpl implements DataProviderService {


    private final ProviderRespository providerRespository;

    @Override
    public LoadBatch getTotalRecords(String providerId) {
        LoadBatch provider = providerRespository.findByProvider(providerId);

        if (provider == null) {
            throw new SpartaNotFoundException(providerId, LoadBatch.class.getName());
        }

        return provider;
    }
}
