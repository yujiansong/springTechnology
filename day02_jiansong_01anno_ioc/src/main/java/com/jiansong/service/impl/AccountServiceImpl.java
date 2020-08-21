package com.jiansong.service.impl;

import com.jiansong.dao.IAccountDao;
import com.jiansong.dao.impl.AccountDaoImpl;
import com.jiansong.service.IAccountService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

/**
 * 账户业务层实现类
 * 曾经的xml配置
 * <bean id="accountService" class="com.jiansong.service.impl.AccountServiceImpl"
 *      scope="" init-method="" destroy-method=""
 *      <property name="" value="" |ref=""></property>
 * >
 * </bean>
 *
 * 用于创建对象的
 *      作用和xml文件中编写一个<bean></bean>标签的作用是一样的
 * @Component: 把当前类对象存入spring容器中
 *      value:用于指定bean的id,我们不写时，默认是当前类名首字母小写
 * @Controller: 一般用于标签层
 * @Service: 一般用于业务层
 * @Repository: 一般用于持久层
 * 用于注入数据的
 *      作用和xml文件中<bean>标签中编写一个<property>标签作用是一样的
 * 用于改变作用范围的
 *      作用和xml文件中<bean>标签中编写一个<scope>标签是一样的
 * 和生命周期相关
 *      作用和xml文件中<bean>标签里编写init-method, destroy-method属性是一样的
 */

@Service(value = "accountService")
public class AccountServiceImpl implements IAccountService {
    private IAccountDao accountDao;

    public AccountServiceImpl() {
        System.out.println("对象创建了");
    }
    public void saveAccount() {
        accountDao.saveAccount();
    }
}
