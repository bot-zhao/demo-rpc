package com.demo.rpc.service;

import com.demo.rpc.model.RpcRequest;
import com.demo.rpc.model.RpcResponse;
import com.demo.rpc.registry.LocalRegistry;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;

/**
 * @author zhaocc
 * @version 1.0
 * @date 2024-12-04 19:56
 */
@RestController
@RequestMapping(value = "/rpc")
public class RpcService {

    @PostMapping
    public RpcResponse test(@RequestBody RpcRequest request) {
        // 构造响应结果对象
        RpcResponse response = new RpcResponse();
        try {
            // 获取要调用的服务实现类，通过反射调用
            Class<?> implClazz = LocalRegistry.get(request.getServiceName());
            Method method = implClazz.getMethod(request.getMethodName(), request.getParameterTypes());
            Object result = method.invoke(implClazz.newInstance(), request.getArgs());
            response.setData(result);
            response.setDataType(method.getReturnType());
            response.setMessage("ok");
        } catch (Exception e) {
            e.printStackTrace();
            response.setMessage(e.getMessage());
            response.setException(e);
        }

        return response;
    }
}
