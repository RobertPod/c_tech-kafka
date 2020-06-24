package com.ctech.consumer1.utils;

import org.apache.avro.io.BinaryEncoder;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.specific.SpecificDatumWriter;
import org.apache.avro.specific.SpecificRecordBase;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ByteArraySerializerUtil {

    private ByteArraySerializerUtil() {

    }

    public static <T extends SpecificRecordBase> byte [] serialize (T avroBean) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        BinaryEncoder encoder = EncoderFactory.get().binaryEncoder(outputStream, null);
        DatumWriter<T> writer = new SpecificDatumWriter<>(avroBean.getSchema());

        writer.write(avroBean, encoder);

        encoder.flush();
        outputStream.close();
        return outputStream.toByteArray();
    }
}
