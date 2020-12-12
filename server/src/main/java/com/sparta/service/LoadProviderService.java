package com.sparta.service;

import com.sparta.model.dto.TotalRecordsDTO;

public interface LoadProviderService {

    public TotalRecordsDTO save(String provider, byte[] content) throws Exception;
}
