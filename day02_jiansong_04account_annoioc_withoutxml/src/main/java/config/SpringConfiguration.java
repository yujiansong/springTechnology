package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;

/**
 * 该类是一个配置类，它的作用和bean.xml是一样的
 * Spring中的新注解：
 *      Configuration:
 *          作用：指定当前类是一个配置类
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
 */

@Configuration
@ComponentScan("com.jiansong")
public class SpringConfiguration {

    /**
     * 创建一个QueryRunner对象
     * @param dataSource
     * @return
     */
    @Bean(name = "runner")
    @Scope("prototype")
    public QueryRunner createQueryRunner(DataSource dataSource) {
        return new QueryRunner(dataSource);
    }

    /**
     * 创建数据源对象
     * @return
     */
    @Bean(name = "dataSource")
    public DataSource createDataSource() {
        try {
            ComboPooledDataSource ds = new ComboPooledDataSource();
            ds.setDriverClass("com.mysql.jdbc.Driver");
            ds.setJdbcUrl("jdbc:mysql://localhost:3306/essy?serverTimezone=GMT%2B8");
            ds.setUser("root");
            ds.setPassword("123456");
            return ds;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
