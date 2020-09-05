package com.jiansong.factory;

import com.jiansong.domain.Account;
import com.jiansong.service.IAccountService;
import com.jiansong.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BeanFactory {
    private IAccountService accountService;
    private TransactionManager transactionManager;

    public final void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public IAccountService getAccountService() {
        return (IAccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(), accountService.getClass().getInterfaces(), new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object rtValue = null;
                try {
                    //1.开启事务
                    transactionManager.beginTransaction1();
                    //2.执行操作
                    rtValue = method.invoke(accountService, args);
                    //3.提交事务
                    transactionManager.commit();
                    //4.返回结果
                    return rtValue;
                } catch (Exception e) {
                    //5.回滚操作
                    transactionManager.rollback();
                    throw new RuntimeException(e);
                } finally {
                    //6.释放连接
                    transactionManager.release();
                }
            }
        });
    }

    public void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }


}
