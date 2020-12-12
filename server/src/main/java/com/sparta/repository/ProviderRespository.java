package com.sparta.repository;

import com.sparta.model.LoadBatch;

public interface ProviderRespository {

    public LoadBatch save(LoadBatch provider);

    public LoadBatch findByProvider(String id);

}
