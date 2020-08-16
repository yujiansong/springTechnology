package com.jiansong.service.impl;

import com.jiansong.dao.IAccountDao;
import com.jiansong.factory.BeanFactory;
import com.jiansong.service.IAccountService;

/**
 * 账户业务层实现类
 */
public class AccountServiceImpl implements IAccountService {
//    private IAccountDao accountDao = new AccountDaoImpl();
    private IAccountDao accountDao = (IAccountDao) BeanFactory.getBean("accountDao");

//    private int i = 1;
    public void saveAccount() {
        int i = 1;
        accountDao.saveAccount();
        System.out.println(i);
        i++;
    }
}
