package com.jiansong.service.impl;

import com.jiansong.service.IAccountService;

/**
 * 账户业务层实现类
 */
public class AccountServiceImpl implements IAccountService {

    public AccountServiceImpl() {
        System.out.println("对象创建了");
    }
    public void saveAccount() {
        System.out.println("AccountServiceImpl中的saveAccount方法执行了");
    }
}
