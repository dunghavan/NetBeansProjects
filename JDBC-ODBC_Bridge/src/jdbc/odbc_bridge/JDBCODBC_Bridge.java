/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.odbc_bridge;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
/**
 *
 * @author Reus
 */
public class JDBCODBC_Bridge {

    public static Connection getConnJDBC_ODBC() throws SQLException, ClassNotFoundException {
        String dataSourceName = "mySQL_DSN";
        String userName = "root";
        String pass = "1235";
        return getConnJDBC_ODBC(dataSourceName, userName, pass);
    }
    public static Connection getConnJDBC_ODBC(String dataSourceName, String userName, String pass)
            throws SQLException, ClassNotFoundException{
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        String connURL = "jdbc:odbc:" + dataSourceName;
        return DriverManager.getConnection(connURL, userName, pass);
    }
    public static void QueryDataExample() throws SQLException, ClassNotFoundException{
        Connection conn = getConnJDBC_ODBC();
        Statement sta = conn.createStatement();
        String query = "select EMP_NAME, SALARY from Employee";
        ResultSet rs = sta.executeQuery(query);
        while(rs.next()){
            String name = rs.getString(1);
            Float salary = rs.getFloat("SALARY");
            System.out.print("\n\tName: " + name);
            System.out.print("\tSalary: " + salary);
        }
    }
    public static void main(String[] args) {
        try {
            JDBCODBC_Bridge.QueryDataExample();
        }
        catch (Exception e){
            System.out.println("Loi: " + e.getMessage());
        }
        finally{
            System.out.println("Finish!");
        }
    }
}
