package com.javarush.task.task32.task3206;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ItemInvocationHandler implements InvocationHandler {
    public Item item;

//    public ItemInvocationHandler(Item item) {
//        this.item = item;
//    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("!");
        return null;
    }
}