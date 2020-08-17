package com.jiansong.service.impl;

import com.jiansong.dao.IAccountDao;
import com.jiansong.dao.impl.AccountDaoImpl;
import com.jiansong.service.IAccountService;

/**
 * 账户业务层实现类
 */
public class AccountServiceImpl implements IAccountService {
    private IAccountDao accountDao = new AccountDaoImpl();

    public void saveAccount() {
        accountDao.saveAccount();
    }
}
