package com.sparta.core;

import com.sparta.model.LoadBatch;
import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayInputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;

@Slf4j
public class ProviderDeserializer {
    
    public static final LoadBatch deserializer(byte[] content) throws Exception {
        ByteArrayInputStream bis = new ByteArrayInputStream(content);
        ObjectInput in = new ObjectInputStream(bis);
        LoadBatch provider = (LoadBatch) in.readObject();
        in.close();

        return provider;
    }
}
