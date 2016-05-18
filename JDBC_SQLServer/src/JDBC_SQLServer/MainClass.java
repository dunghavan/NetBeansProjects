/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBC_SQLServer;

import java.sql.SQLException;

/**
 *
 * @author Reus
 */
public class MainClass {
    public static void main(String[] args) {
        try{
            int x;
            JDBC_ODBC_Bridge.QueryData();
        }
        catch(ClassNotFoundException | SQLException e){
            System.out.println(e.getMessage());
        }
        finally {
        //
        }
    }
}
