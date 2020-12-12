package com.sparta.service.impl;

import com.sparta.core.ProviderDeserializer;
import com.sparta.model.dto.TotalRecordsDTO;
import com.sparta.service.LoadProviderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LoadProviderServiceImpl implements LoadProviderService {

    @Override
    public TotalRecordsDTO save(String provider, byte[] content) throws Exception {

        ProviderDeserializer.deserializer(content);

        return null;
    }
}
