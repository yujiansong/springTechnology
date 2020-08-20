package com.jiansong.service.impl;

import com.jiansong.service.IAccountService;

import java.util.Date;

/**
 * 账户业务层实现类
 */
public class AccountServiceImpl2 implements IAccountService {
    //经常发生变化的数据，不适合注入
    private String name;
    private Integer age;
    private Date birthday;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void saveAccount() {
        System.out.println("service中的saveAccount方法执行了" + ", name:" + name + ",age:" + age + ",birthday:" + birthday);
    }
}
