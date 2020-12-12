package com.sparta.service.impl;

import com.sparta.core.ProviderDeserializer;
import com.sparta.core.exceptions.SpartaException;
import com.sparta.model.LoadBatch;
import com.sparta.repository.ProviderRespository;
import com.sparta.service.LoadProviderService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class LoadProviderServiceImpl implements LoadProviderService {

    private final ProviderRespository providerRespository;

    @Override
    public LoadBatch save(String provider, byte[] content) {
        try {

            return providerRespository.save(ProviderDeserializer.deserializer(content));
        } catch (Exception e) {
            throw new SpartaException(e.getMessage());
        }
    }
}
