package com.sparta.service.impl;

import com.sparta.core.ProviderDeserializer;
import com.sparta.core.exceptions.SpartaException;
import com.sparta.model.dto.TotalRecordsDTO;
import com.sparta.model.dto.factory.TotalRecordsFactory;
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
    public TotalRecordsDTO save(String provider, byte[] content) {
        try {
            return TotalRecordsFactory.newInstance(providerRespository.save(provider, ProviderDeserializer.deserializer(content)).size());
        } catch (Exception e) {
            throw new SpartaException(e.getMessage());
        }
    }
}
