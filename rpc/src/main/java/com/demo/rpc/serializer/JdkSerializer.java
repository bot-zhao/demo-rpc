package com.demo.rpc.serializer;

import java.io.*;

/**
 * JDK 序列化器
 *
 * @author zhaocc
 * @version 1.0
 * @date 2024-12-04 19:15
 */
public class JdkSerializer implements Serializer {

    @Override
    public <T> byte[] serialize(T object) throws IOException {
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(bos);) {
            oos.writeObject(object);
            oos.close();
            return bos.toByteArray();
        }

    }

    @Override
    public <T> T deserialize(byte[] bytes, Class<T> type) throws IOException {
        try (ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
             ObjectInputStream ois = new ObjectInputStream(bis)) {
            return (T) ois.readObject();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
