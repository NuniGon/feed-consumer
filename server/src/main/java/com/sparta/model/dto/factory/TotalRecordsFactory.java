package com.sparta.model.dto.factory;

import com.sparta.model.dto.TotalRecordsDTO;

public class TotalRecordsFactory {

    public static TotalRecordsDTO newInstance(long totalRecords) {
        return new TotalRecordsDTO(totalRecords);
    }
}
