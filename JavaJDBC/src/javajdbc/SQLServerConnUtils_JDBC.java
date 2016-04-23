package javajdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
 
public class SQLServerConnUtils_JDBC {
 
 // Kết nối vào SQLServer sử dụng thư viện điều khiển SQLJDBC hoặc JTDS
 public static Connection getSQLServerConnection()
         throws SQLException, ClassNotFoundException {
     String hostName = "localhost";
     String sqlInstanceName = "SQLEXPRESS";
     String database = "DBforJava";
     String userName = "sa";
     String password = "1532";
 
     return getSQLServerConnection(hostName, sqlInstanceName,
             database, userName, password);
 }
 
 public static Connection getSQLServerConnection(String hostName,
         String sqlInstanceName, String database, String userName,
         String password) throws ClassNotFoundException, SQLException {
     // Khai báo class Driver cho DB SQLServer (chỉ cần đối với java5)
     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
     // Khi dùng JTDS thì là: 
     //Class.forName("net.sourceforge.jtds.jdbc.Driver");
 
     // Cấu trúc URL Connection dành cho SQLServer
     // Ví dụ khi dùng trình điều khiển SQLJDBC:
     // jdbc:sqlserver://ServerIp:1433/SQLEXPRESS;databaseName=simplehr
     String connectionURL = "jdbc:sqlserver://" + hostName + ":1433"
             + ";instance=" + sqlInstanceName + ";databaseName=" + database;
     //Còn khi dùng trình điều khiển JTDS:
     // jdbc:jtds:sqlserver://localhost:1433/simplehr;instance=SQLEXPRESS
     //String connectionURL = "jdbc:jtds:sqlserver://" + hostName + ":1433"
     // +";instance=" + sqlInstanceName + ";databaseName=" + database;
 
     Connection conn = DriverManager.getConnection(connectionURL, userName, password);
     return conn;
 }
 public static void QueryDataExample() throws SQLException, ClassNotFoundException {
     try (Connection conn = SQLServerConnUtils_JDBC.getSQLServerConnection()) {
         Statement statement = conn.createStatement();
         String query = "select EMP_ID, EMP_NAME, SALARY from Employee";
         ResultSet rs = statement.executeQuery(query);
         while(rs.next())
         {
             int id = rs.getInt(1);
             String name = rs.getString(2);
             Float salary = rs.getFloat("SALARY");
             System.out.print("\n\tID: " + id);
             System.out.print("\t|Name: " + name);
             System.out.print("\t|Salary: " + salary);
         }
     }
}
}