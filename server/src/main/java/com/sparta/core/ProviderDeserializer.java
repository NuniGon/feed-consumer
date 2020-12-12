package com.sparta.core;

import com.sparta.model.Record;
import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.util.List;

@Slf4j
public class ProviderDeserializer {

    public static final List<Record> deserializer(byte[] content) throws Exception {
        ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(content));
        List<Record> provider = (List<Record>) in.readObject();
        in.close();

        return provider;
    }
}
