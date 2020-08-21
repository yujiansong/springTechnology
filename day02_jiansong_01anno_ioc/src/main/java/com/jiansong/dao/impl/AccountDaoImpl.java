package com.jiansong.dao.impl;

import com.jiansong.dao.IAccountDao;
import org.springframework.stereotype.Repository;

/**
 * 账户持久实现类
 */
@Repository(value = "accountDao")
public class AccountDaoImpl implements IAccountDao {
    public void saveAccount() {
        System.out.println("保存了账户");
    }
}
