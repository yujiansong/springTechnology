package com.jiansong.service.impl;

import com.jiansong.dao.IAccountDao;
import com.jiansong.domain.Account;
import com.jiansong.service.IAccountService;
import com.jiansong.utils.TransactionManager;

import java.util.List;

public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;
    private TransactionManager transactionManager;

    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public List<Account> findAllAccount() {

        return accountDao.findAllAccount();
    }

    public Account findAccountById(Integer accountId) {

        return accountDao.findAccountById(accountId);
    }

    public void saveAccount(Account account) {

        accountDao.saveAccount(account);
    }

    public void updateAccount(Account account) {

        accountDao.updateAccount(account);
    }

    public void deleteAccount(Integer accountId) {

        accountDao.deleteAccount(accountId);
    }

    public void transfer(String sourceName, String targetName, Float money) {

        //2.1.根据名称查询转出账户
        Account source = accountDao.findAccountByName(sourceName);
        //2.2.根据名称查询转入账户
        Account target = accountDao.findAccountByName(targetName);
        //2.3.转出账户减钱
        source.setMoney(source.getMoney() - money);
        //2.4.转出账户加钱
        target.setMoney(target.getMoney() + money);
        //2.5.更新转出账户
        accountDao.updateAccount(source);

        int i = 1 / 0;

        //2.6.更新转入账户
        accountDao.updateAccount(target);
    }


}
