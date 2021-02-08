package com.example.myapplication.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxySubject implements InvocationHandler {

    private Subject proxySubject;

    public ProxySubject(Subject proxySubject) {
        this.proxySubject = proxySubject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(proxySubject, args);
    }
}
