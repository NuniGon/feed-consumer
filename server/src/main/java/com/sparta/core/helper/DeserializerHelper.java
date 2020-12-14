package com.sparta.core.helper;

import com.sparta.core.exceptions.ChecksumCRC32Exception;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.zip.CRC32;
import java.util.zip.Checksum;

public class DeserializerHelper {

    public static String bytesToStringUTF8(byte[] byteString) {
        return new String(StandardCharsets.UTF_8.decode(ByteBuffer.wrap(byteString)).array());
    }

    public static long getChecksumCRC32(ByteBuffer byteBuffer, int numBytesCRC32) {
        Checksum checksum = new CRC32();
        int position = byteBuffer.position();
        byte[] dataSensor = new byte[numBytesCRC32];

        byteBuffer.get(dataSensor);
        checksum.update(dataSensor, 0, dataSensor.length);

        long val = checksum.getValue();
        long byteval = byteBuffer.getLong();

        byteBuffer.position(position);
        if (val != byteval) {
            throw new ChecksumCRC32Exception("Checksum are invalid");
        }

        return checksum.getValue();
    }

}
