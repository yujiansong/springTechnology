package com.jiansong.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 模拟一个消费者
 */
public class Client {
    public static void main(String[] args) {
        final Producer producer = new Producer();


        IProducer proxyProducer = (IProducer) Proxy.newProxyInstance(producer.getClass().getClassLoader(),
                producer.getClass().getInterfaces(),
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //提供增强的代码
                        Object returnValue = null;
                        Float money = (Float)args[0];
                        if ("saleProduce".equals(method.getName())) {
                            returnValue = method.invoke(producer, money * 0.8f);
                        }
                        return  returnValue;

                    }
                });
        producer.saleProduce(10000f);
    }
}
