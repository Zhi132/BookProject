package com.nuc.util;

import com.nuc.util.DatabaseUtil;

import java.sql.*;

public class BaseDao {

    String driver = "com.mysql.jdbc.Driver";
    String username = "root";
    String password = "123456";
    String url = "jdbc:mysql://localhost:3306/bookshop?useUnicode=true&characterEncoding=utf8";
    Connection conn = null;

    public Connection getConn(){

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,username,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 增、删、改操作
     * @param sql
     *        语句
     * @param params
     *         参数数组
     * @return 执行结果
     */
    public int executeUpdate(String sql,Object...params){
        int result=0;
        PreparedStatement pstmt=null;
        try {
            pstmt=conn.prepareStatement(sql);
            for (int i=0;i<params.length;i++){
                pstmt.setObject(i+1,params[i]);
            }
            result=pstmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DatabaseUtil.closeAll(null,pstmt,null);
        }
        return  result;
    }

    /**
     *
     * @param sql
     *        语句
     * @param params
     *         参数数组
     * @return  查询结果集
     */
    public ResultSet executeQuery(String sql, Object...params){
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try {
            pstmt=conn.prepareStatement(sql);
            for (int i=0;i<params.length;i++){
                pstmt.setObject(i+1,params[i]);
            }
            rs=pstmt.executeQuery();
        }catch (Exception e){
            e.printStackTrace();
        }
        return  rs;
    }

}