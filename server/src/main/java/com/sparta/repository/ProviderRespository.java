package com.sparta.repository;

import com.sparta.model.Record;

import java.util.List;

public interface ProviderRespository {

    public List<Record> save(String provider, List<Record> records);

    public List<Record> findByProvider(String provider);

}
