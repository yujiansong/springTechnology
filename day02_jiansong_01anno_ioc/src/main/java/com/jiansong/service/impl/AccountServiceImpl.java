package com.jiansong.service.impl;

import com.jiansong.dao.IAccountDao;
import com.jiansong.dao.impl.AccountDaoImpl;
import com.jiansong.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

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
 * @Autowired： 自动按照类型注入，只要容器中有为一个bean对象类型和注入的对象类型匹配，就可以注入成功
 *      出现位置：可以在变量上，也可以在方法上。
 * @Qualifier: 再按照类中注入的基础之上再按照名称注入。他在给类成员注入时不能单独使用。但是给方法参数注入时可以
 *      属性:
 *          value； 用于指定注入bean的id
 * @Resource: 直接bean的id注入
 *      name: 指定bean的id
 *
 * 以上三个注入都只能注入其它bean类型的数据，而基本类型和String类型的数据无法注入
 * 另外，集合类型的注入只能通过xml来实现
 *
 * Value: 用于注入基本类型和String类型的数据
 * 属性：
 *      value:用于指定数据的值，它可以使用spring中的spel表达式（也就是spring的el表达式）
 *      Spel的写法： ${表达式}
 * 用于改变作用范围的
 *      作用和xml文件中<bean>标签中编写一个<scope>标签是一样的
 *      Scope: 用于指定bean的作用范围
 *             属性：
 *             value: 指定范围的取值， 常用取值 singleton, prototype
 *
 * 和生命周期相关
 *      作用和xml文件中<bean>标签里编写init-method, destroy-method属性是一样的
 *
 *      PreDestroy:
 *          作用：用于销毁方法
 *      PostConstruct:
 *          作用：用于初始化方法
 */

@Service(value = "accountService")
//@Scope("prototype")
public class AccountServiceImpl implements IAccountService {
//    @Autowired
//    @Qualifier("accountDao1")
    @Resource(name = "accountDao2")
    private IAccountDao accountDao = null;

//    public AccountServiceImpl() {
//        System.out.println("对象创建了");
//    }
    public void saveAccount() {
        accountDao.saveAccount();
    }

    @PostConstruct
    public void init() {
        System.out.println("初始化方法");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("销毁方法");
    }
}
