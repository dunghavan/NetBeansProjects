/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBC_SQLServer;

import java.sql.*;

/**
 *
 * @author Reus
 */
public class JDBC_ODBC_Bridge {
    public static Connection CreateConnection() throws ClassNotFoundException, SQLException {
        Connection conn;
        //Buoc 1: Tai Class Driver:
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        // Buoc 2: Tao doi tuong connection:
        //String hostName = "localhost";
        //String sqlInstance = "SQLEXPRESS";
        //String DatabaseName = "DBforJava";
        String DSN = "newDSN";
        String userName = "root";
        String password = "1235";
        String URL = "jdbc:odbc:" + DSN;
        conn = DriverManager.getConnection(URL, userName, password);
        return conn;
    }
    public static void QueryData()throws ClassNotFoundException, SQLException{
        //Buoc 3: Tao doi tuong Statement:
        Connection conn = CreateConnection();
        Statement sta = conn.createStatement();
        //Buoc 4: Thuc hien viec truy van du lieu:
        ResultSet rs = sta.executeQuery("SELECT DEPT_ID, DEPT_NAME, DEPT_NO, LOCATION FROM DEPARTMENT");
        System.out.println("----------KET NOI CSDL SU DUNG ODBC_BRIDGE----------");
        while(rs.next())
        {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            String no = rs.getString(3);
            String location = rs.getString(4);
            System.out.println("ID: " + id + "   |Name: " + name + "   |No: " + no + "   |Location: " + location);
        }
        // Kiem tra Connection close
        conn.close();
        if(conn.isClosed()){
            System.out.println("Ket noi da duoc dong");
          } 
//        rs = sta.executeQuery("SELECT DEPT_NAME FROM DEPARTMENT");
//        while(rs.next())
//        {
//            String name = rs.getString(1);
//            System.out.println("   |Name: " + name);
//        }
  }
}

