package com.sparta.repository.impl;

import com.sparta.model.LoadBatch;
import com.sparta.repository.ProviderRespository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
@Slf4j
public class ProviderRespositoryImpl implements ProviderRespository {

    private final Map<String, LoadBatch> providerSource = new HashMap<>();

    @Override
    public LoadBatch save(LoadBatch provider) {
        return providerSource.put(provider.getId(), provider);
    }

    @Override
    public LoadBatch findByProvider(String id) {
        return providerSource.get(id);
    }
}
