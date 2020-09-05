package com.jiansong.proxy;

/**
 * 一个生产者
 */
public class Producer implements IProducer{
    /**
     * 销售
     * @param money
     */
    public void saleProduct(float money) {
        System.out.println("王老二销售产品，并拿到了钱：" + money);
    }

    /**
     * 售后
     */
    public void afterService(float money) {
        System.out.println("王老二提供售后， 并拿到了钱：" + money);
    }
}
