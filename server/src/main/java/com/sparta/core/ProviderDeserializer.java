package com.sparta.core;

import com.sparta.core.helper.DeserializerHelper;
import com.sparta.model.LoadBatch;
import com.sparta.model.Record;
import com.sparta.model.Sensor;
import lombok.extern.slf4j.Slf4j;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/*

Reference sources for the Deserializer and CRC32 :
https://github.com/geeksusma/feed-consumer/blob/master/server/src/main/java/com/sparta/provider/load/DeserializeProviderImpl.java
https://stackoverflow.com/questions/42191752/java-crc32-calculation-in-a-multi-threading-envirinment
https://www.baeldung.com/java-checksums
 */

@Slf4j
public class ProviderDeserializer {

    public static final LoadBatch deserializer(String providerId, byte[] content) throws Exception {
        ByteBuffer byteBuffer = ByteBuffer.wrap(content);
        long recordsNumber = byteBuffer.getLong();
        List<Record> records = new ArrayList<>((int) recordsNumber);
        if (byteBuffer != null && byteBuffer.hasRemaining()) {
            for (int i = 0; i < recordsNumber; i++) {
                records.add(recordDeserializer(byteBuffer));
            }
        }
        return new LoadBatch(providerId, recordsNumber, records);
    }

    private static Record recordDeserializer(ByteBuffer byteBuffer) {
        List<Sensor> sensors = null;
        long index = byteBuffer.getLong();
        long timestamp = byteBuffer.getLong();
        String city = getString(byteBuffer);

        int numBytesCRC32 = byteBuffer.getInt();

        if (numBytesCRC32 > 0) {
            DeserializerHelper.getChecksumCRC32(byteBuffer, numBytesCRC32);

            int numSensors = byteBuffer.getInt();
            sensors = new ArrayList<>(numSensors);
            if (numSensors > 0) {
                for (int i = 0; i < numSensors; i++) {
                    sensors.add(new Sensor(getString(byteBuffer), byteBuffer.getInt()));
                }
            }

            byteBuffer.getLong();
        }
        return new Record(index, timestamp, city, sensors);
    }

    private static String getString(ByteBuffer byteBuffer) {
        int stringSize = byteBuffer.getInt();
        if (stringSize == 0) {
            return null;
        }

        byte[] byteString = new byte[stringSize];
        byteBuffer.get(byteString);
        return DeserializerHelper.bytesToStringUTF8(byteString);
    }


}
