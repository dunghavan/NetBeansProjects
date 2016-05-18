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
        Connection conn;
        //Buoc 1: Tai Class Driver:
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        // Buoc 2: Tao doi tuong connection:
        String hostName = "localhost";
        String sqlInstance = "SQLEXPRESS";
        String DatabaseName = "DBforJava";
        String userName = "sa";
        String password = "1532";
        String URL = "jdbc:sqlserver://" + hostName + ":1433;instance=" + sqlInstance + ";databaseName=" + DatabaseName;
        conn = DriverManager.getConnection(URL, userName, password);
        return conn;
    }
    public static void QueryData()throws ClassNotFoundException, SQLException{
        //Buoc 3: Tao doi tuong Statement:
        Statement sta = CreateConnection().createStatement();
        //Buoc 4: Thuc hien viec truy van du lieu:
        ResultSet rs = sta.executeQuery("SELECT EMP_ID, EMP_NAME, SALARY FROM EMPLOYEE");
        while(rs.next())
        {
            int id = rs.getInt("EMP_ID");
            String name = rs.getString("EMP_NAME");
            Float salary = rs.getFloat("SALARY");
            System.out.println("ID: " + id + "   |Name: " + name + "   |Salary: " + salary);
        }
        CreateConnection().close();
    }
}
