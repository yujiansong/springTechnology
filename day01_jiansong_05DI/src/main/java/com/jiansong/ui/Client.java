package com.jiansong.ui;

import com.jiansong.service.IAccountService;
import com.jiansong.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * 模拟一个表现层，用户调用业务层
 */
public class Client {
    /**
     * @param args
     */
    public static void main(String[] args) {
        //1.获取核心容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.根据id获取bean对象
//        IAccountService as = (IAccountService) ac.getBean("accountService");
//        as.saveAccount();

//        IAccountService as = (IAccountService) ac.getBean("accountService2");
//        as.saveAccount();
        IAccountService as = (IAccountService) ac.getBean("accountService3");
        as.saveAccount();
    }
}
