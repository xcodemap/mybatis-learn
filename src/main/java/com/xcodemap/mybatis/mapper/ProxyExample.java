package com.xcodemap.mybatis.mapper;

import com.xcodemap.mybatis.mapper.proxy.Hello;
import com.xcodemap.mybatis.mapper.proxy.HelloImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class HelloInvocationHandler implements InvocationHandler {
    private Object target;

    public HelloInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before method call");
        Object result = method.invoke(target, args);
        System.out.println("After method call");
        return result;
    }
}

public class ProxyExample {
    public static void main(String[] args) {
        Hello hello = new HelloImpl();
        InvocationHandler handler = new HelloInvocationHandler(hello);
        Hello proxy = (Hello) Proxy.newProxyInstance(
                hello.getClass().getClassLoader(),
                hello.getClass().getInterfaces(),
                handler
        );
        System.out.println(proxy.getClass());
        proxy.sayHello();
    }
}

