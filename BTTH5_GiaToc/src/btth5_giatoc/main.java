package btth5_giatoc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class main {
    static GiaToc g;
    static NewJFrame frame = new NewJFrame();
    public  static void main(String []args) throws SoLuongException, IOException{
          frame.setLocation(400, 100);
          frame.setVisible(true);
        try {
            Load_DS_MaTV();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Mã Thành Viên Đã Tồn Tại", "Lỗi!!!", 1);
        }
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
    static void Load_DS_MaTV() throws SQLException{
        Connection conn;
        conn = main.CreateConnection();
        Statement sta = conn.createStatement();
        ResultSet rs = sta.executeQuery("SELECT MaThanhVien FROM DSThanhVien");
        //Gan Du Lieu:
        while(rs.next())
        {
            String matv = rs.getString(1);
            GiaToc.DSmatv.add(matv);
        }
        conn.close();
    }    
}
