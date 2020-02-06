package com.javarush.task.task32.task3205;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CustomInvocationHandler implements InvocationHandler {
    private SomeInterfaceWithMethods siwmi;

    public CustomInvocationHandler(SomeInterfaceWithMethods siwmi) {
        this.siwmi = siwmi;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName()+" in");
        Object ret = method.invoke(siwmi, args);
        System.out.println(method.getName()+" out");
        return ret;
    }
}
