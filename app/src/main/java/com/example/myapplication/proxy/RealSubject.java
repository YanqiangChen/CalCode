package com.example.myapplication.proxy;

public class RealSubject implements Subject{
    @Override
    public String operation() {
        return "RealSubject";
    }
}
