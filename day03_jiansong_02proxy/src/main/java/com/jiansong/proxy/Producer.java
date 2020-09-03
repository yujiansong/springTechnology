package com.jiansong.proxy;

/**
 * 一个生产者
 */
public class Producer implements IProducer{
    /**
     * 销售
     * @param money
     */
    public void saleProduce(float money) {
        System.out.println("销售产品，并拿到钱：" + money);
    }

    /**
     * 售后
     */
    public void afterService(float money) {
        System.out.println("提供售后， 并拿到钱：" + money);
    }
}
