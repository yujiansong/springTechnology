package com.jiansong.ui;

import com.jiansong.factory.BeanFactory;
import com.jiansong.service.IAccountService;
import com.jiansong.service.impl.AccountServiceImpl;

/**
 * 模拟一个表现层，用户调用业务层
 */
public class Client {
    public static void main(String[] args) {
//        IAccountService iAccountService = new AccountServiceImpl();
        for (int i = 0; i < 5; i++) {
            IAccountService iAccountService = (IAccountService) BeanFactory.getBean("accountService");
            System.out.println(iAccountService);
            iAccountService.saveAccount();
        }
//        iAccountService.saveAccount();
    }
}
