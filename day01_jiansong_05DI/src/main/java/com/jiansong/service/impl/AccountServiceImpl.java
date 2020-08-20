package com.jiansong.service.impl;

import com.jiansong.service.IAccountService;

import java.util.Date;

/**
 * 账户业务层实现类
 */
public class AccountServiceImpl implements IAccountService {
    //经常发生变化的数据，不适合注入
    private String name;
    private Integer age;
    private Date birthday;
    public AccountServiceImpl(String name, Integer age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public void saveAccount() {
        System.out.println("service中的saveAccount方法执行了" + ", name:" + name + ",age:" + age + ",birthday:" + birthday);
    }
}
