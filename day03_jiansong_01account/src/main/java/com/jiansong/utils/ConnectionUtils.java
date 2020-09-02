package com.jiansong.utils;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * 连接的一个工具类，他用于从数据源中获取一个连接，并且实现和线程绑定
 */
public class ConnectionUtils {
    private ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    private DataSource dataSource;

    /**
     * 获取当前线程的连接
     */
    public Connection getThreadConnection() {
        //1.先从ThreadLocal上获取
        Connection conn = tl.get();
        //2.判断当前线程是否有连接
        try {
            if (conn == null) {
                conn = dataSource.getConnection();
                tl.set(conn);
            }
            //返回当前线程的连接
            return conn;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //把链接和线程解绑
    public void removeConnection() {
        tl.remove();
    }
}
