package com.taobao.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBHelper {
    public static final String url="jdbc:mysql://127.0.0.1:3306/servlet?useSSL=false";//&characterEncoding=UTF-8
    public static final String driver="com.mysql.jdbc.Driver";
    public static final String user="root";
    public static final String password="123456";

    public Connection conn=null;
    public PreparedStatement pstm=null;

    static {
        try {
            Class.forName(driver);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public DBHelper(){}
    public DBHelper(String sql){
        try {
            conn= DriverManager.getConnection(url,user,password);
            pstm=conn.prepareStatement(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public Connection getConn(){
        try {
            conn=DriverManager.getConnection(url,user,password);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public  void close(){
        try {
            this.pstm.close();
            this.conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
