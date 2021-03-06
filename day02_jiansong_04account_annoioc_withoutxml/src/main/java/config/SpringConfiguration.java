package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

/**
 * 该类是一个配置类，它的作用和bean.xml是一样的
 * Spring中的新注解：
 *      Configuration:
 *          作用：指定当前类是一个配置类
 *          细节：当配置类作为AnnotationConfigApplicationContext对象创建的参数时，该注解可以不写
 *      ComponentScan:
 *          作用：用于通过注解指定spring创建容器时扫描的包
 *          属性： value 和  basePackages 的作用是一样的，都是用于指定创建容器时要扫描的包
 *          我们使用此注解就等同于在xml文件中配置了
 *          <context:component-scan base-package="com.jiansong"></context:component-scan>
 *
 *      Bean:
 *          作用：用于把当前方法的返回值作为Bean对象，存入Spring的IOC容器中
 *          name:用于指定bean的id, 不写默认是当前方法的名称
 *          细节：
 *          当我们使用注解配置方法时，如果方法有参数，spring框架会去容器中查找有没有可用的Bean对象
 *          查找的方式和AutoWired注解的作用是一样的
 *     Import:
 *          作用：用于导入其它类的配置类
 *          属性：
 *              value: 用于指定其它配置类的字节码
 *                      当我们使用Import的注解之后，有Import注解的类是父配置类，其它导入的是子配置类
 */

//@Configuration
//@ComponentScan({"com.jiansong", "config"})
@ComponentScan("com.jiansong")
@Import(JdbcConfig.class)
@PropertySource("classpath:jdbcConfig.properties")
public class SpringConfiguration {


}
