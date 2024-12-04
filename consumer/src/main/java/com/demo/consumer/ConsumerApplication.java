package com.demo.consumer;

import com.demo.common.model.User;
import com.demo.common.service.UserService;
import com.demo.rpc.proxy.ServiceProxyFactory;

/**
 * @author zhaocc
 * @version 1.0
 * @date 2024-12-04 19:35
 */
public class ConsumerApplication {
    public static void main(String[] args) {
        // TODO 需要代理
        UserService userService = ServiceProxyFactory.getProxy(UserService.class);
        User user = userService.getUser();
        System.out.println(user);
    }
}
