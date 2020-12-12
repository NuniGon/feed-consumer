package com.sparta.repository.impl;

import com.sparta.model.Record;
import com.sparta.repository.ProviderRespository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Slf4j
public class ProviderRespositoryImpl implements ProviderRespository {

    private final Map<String, List<Record>> providerSource = new HashMap<>();

    @Override
    public List<Record> save(String provider, List<Record> records) {
        return providerSource.put(provider, records);
    }

    @Override
    public List<Record> findByProvider(String provider) {
        return providerSource.get(provider);
    }
}
