package com.sparta.service;

import com.sparta.model.LoadBatch;

public interface LoadProviderService {

    public LoadBatch save(String provider, byte[] content) throws Exception;
}
