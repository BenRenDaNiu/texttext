package com.taobao.dao;




import com.taobao.model.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBOper {

    public Account addUser(Account acc){


        Connection conn=new DBHelper().getConn();
        String sql="insert into reg(account,password)values(?,?)";
        try {
            PreparedStatement pstmt=conn.prepareStatement(sql);
            int i=1;
            pstmt.setInt(i++,acc.getAccount());
            pstmt.setString(i++,acc.getPasswprd().trim());
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return acc;
    }
    public boolean isaccountcode(int accountcode){
        boolean bok=false;
        Connection conn=new DBHelper().getConn();
        String sql="select account from reg where account=?";
        try {
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,accountcode);
            ResultSet rs=pstmt.executeQuery();
            if (rs.next()){
                bok=true;
            }
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bok;
    }
    /*  public static void main(String[] args) {
        // updateFriend();
        //Delete();
         // Update();
       //   select();
      }*/
    public Account login(Account acc){
        Connection conn=new DBHelper().getConn();
        String sql="select * from reg where account=? and password=?";
        try {
            PreparedStatement pstmt=conn.prepareStatement(sql);
            int i=1;
            pstmt.setInt(1,acc.getAccount());
            pstmt.setString(2,acc.getPasswprd());
            ResultSet rs=pstmt.executeQuery();
            if (rs.next()){
                acc.setStatus(1);
                modifyStatus(acc.getAccount(),1);//修改状态为在线，修改数据库中的状态


            }
            rs.close();
            pstmt.close();

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return acc;
    }



    public boolean modifyStatus(int qqcode,int status){
        boolean bok=false;
        Connection conn=new DBHelper().getConn();
        String sql="update reg set status=? where account=?";
        try {
            PreparedStatement pstmt =conn.prepareStatement(sql);
            int i=1;
            pstmt.setInt(i++,status);
            pstmt.setInt(i++,qqcode);
            if(pstmt.executeUpdate()>0){
                bok=true;

            }
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bok;
    }
}
