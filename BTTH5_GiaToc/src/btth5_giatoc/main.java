package btth5_giatoc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class main {
    static GiaToc g;
    static NewJFrame frame = new NewJFrame();
    public  static void main(String []args) throws SoLuongException, IOException{
          frame.setLocation(400, 100);
          frame.setVisible(true);
          
    }
    static Connection CreateConnection() throws SQLException{
        Connection conn;
        String hostName = "localhost";  //Ten server ma SQL Server dang chay
        String sqlInstance = "SQLEXPRESS";
        String DatabaseName = "GiaToc";
        String userName = "sa";
        String password = "1532";
        String URL = "jdbc:sqlserver://" + hostName + ":1433;instance=" + sqlInstance + ";databaseName=" + DatabaseName;
        return conn = DriverManager.getConnection(URL, userName, password);
    }
//        
}
