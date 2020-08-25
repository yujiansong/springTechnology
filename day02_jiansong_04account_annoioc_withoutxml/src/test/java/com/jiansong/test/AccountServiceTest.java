package com.jiansong.test;

import com.jiansong.domain.Account;
import com.jiansong.service.IAccountService;
import config.SpringConfiguration;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * 使用Junit单元测试，测试我们的配置
 */
public class AccountServiceTest {

    @Test
    public void testFindAll() {
        //获取容器
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //得到业务层对象
        IAccountService accountService = ac.getBean("accountService", IAccountService.class);
        List<Account> accounts = accountService.findAllAccount();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    @Test
    public void testFindOne() {
        //获取容器
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //得到业务层对象1
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);

        IAccountService accountService = ac.getBean("accountService", IAccountService.class);
        Account account = accountService.findAccountById(1);
        System.out.println(account);
    }

    @Test
    public void testSave() {
        Account account = new Account();
        account.setName("wangtianshi");
        account.setMoney(150000);
        //获取容器
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);

        //得到业务层对象
        IAccountService accountService = ac.getBean("accountService", IAccountService.class);
        accountService.saveAccount(account);
    }

    @Test
    public void testUpdate() {
        //获取容器
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);

        //得到业务层对象
        IAccountService accountService = ac.getBean("accountService", IAccountService.class);
        Account account = accountService.findAccountById(2);
        account.setMoney(150000);
        accountService.updateAccount(account);
    }

    @Test
    public void testDelete() {
        //获取容器
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);

        //得到业务层对象
        IAccountService accountService = ac.getBean("accountService", IAccountService.class);
        accountService.deleteAccount(4);
    }
}
