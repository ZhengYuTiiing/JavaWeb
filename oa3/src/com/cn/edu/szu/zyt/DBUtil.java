package com.cn.edu.szu.zyt;

import java.sql.*;
import java.util.ResourceBundle;

public class DBUtil {
    private static ResourceBundle bundle=ResourceBundle.getBundle("resources.jdbc");
    private static String driver=bundle.getString("driver");
    private static String url=bundle.getString("url");
    private static String user=bundle.getString("user");
    private static String password=bundle.getString("password");

    //注册驱动，只需要注册一次,放在静态代码块中
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public  static Connection getConnection() throws SQLException {

        //获取连接
        Connection connection = DriverManager.getConnection(url, user, password);
        return connection;
        //获取操作对象

        //执行sql
        //处理查询结果集
        //释放资源
    }

    /**
     * 释放资源
     * @param conn
     * @param stmt
     * @param rs
     */
    public static void close(Connection conn, Statement stmt, ResultSet rs){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if(stmt!=null){
            try {
                stmt.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
