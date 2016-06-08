/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBC_SQLServer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Reus
 */
public class JDBC_SQLServer {
    public static Connection CreateConnection() throws ClassNotFoundException, SQLException {
        //Buoc 1: Tai Class Driver:
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        // Buoc 2: Tao doi tuong connection:
        String hostName = "localhost";  //Ten server ma SQL Server dang chay
        String sqlInstance = "SQLEXPRESS";
        String DatabaseName = "DBforJava";
        String userName = "sa";
        String password = "1532";
        String URL = "jdbc:sqlserver://" + hostName + ":1433;instance=" + sqlInstance + ";databaseName=" + DatabaseName;
        return DriverManager.getConnection(URL, userName, password);
    }
    public static void QueryData()throws ClassNotFoundException, SQLException{
        Connection conn;
        conn = CreateConnection();
        //Buoc 3: Tao doi tuong Statement:
        Statement sta = conn.createStatement();
        //Buoc 4: Thuc hien viec truy van du lieu:
        ResultSet rs = sta.executeQuery("SELECT EMP_ID, EMP_NAME, SALARY FROM EMPLOYEE");
        System.out.println("----------KET NOI CSDL SU DUNG DRIVER FOR SQL SERVER----------");
        while(rs.next())
        {
            int id = rs.getInt("EMP_ID");
            String name = rs.getString("EMP_NAME");
            Float salary = rs.getFloat("SALARY");
            System.out.println("ID: " + id + "   |Name: " + name + "   |Salary: " + salary);
        }
        conn.close();
    }
}
