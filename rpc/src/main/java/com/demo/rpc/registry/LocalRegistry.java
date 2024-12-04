package com.demo.rpc.registry;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 本地注册器
 *
 * @author zhaocc
 * @version 1.0
 * @date 2024-12-04 19:42
 */
public class LocalRegistry {
    /**
     * 本次注册器
     */
    private static final Map<String, Class<?>> REGISTRY = new ConcurrentHashMap<>();

    /**
     * 注册
     *
     * @param serviceName
     * @param impleClass
     */
    public static void register(String serviceName, Class<?> impleClass) {
        REGISTRY.put(serviceName, impleClass);
    }

    /**
     * 获取
     *
     * @param serviceName
     * @return
     */
    public static Class<?> get(String serviceName) {
        return REGISTRY.get(serviceName);
    }

    /**
     * 移除
     *
     * @param serviceName
     */
    public static void remove(String serviceName) {
        REGISTRY.remove(serviceName);
    }
}
