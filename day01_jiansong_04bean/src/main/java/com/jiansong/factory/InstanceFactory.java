package com.jiansong.factory;

import com.jiansong.service.IAccountService;
import com.jiansong.service.impl.AccountServiceImpl;

/**
 * 模拟一个工厂类（该类可能存在与jar包中的，我们无法通过修改源码的方式来提供默认构造函数）
 */
public class InstanceFactory {

    public IAccountService getAccountService() {
        return new AccountServiceImpl();
    }
}
