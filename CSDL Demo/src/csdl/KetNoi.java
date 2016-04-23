/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package csdl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
/**
 *
 * @author Administrator
 */
public class KetNoi
{
    private Connection cn;
    private String chuoi_ket_noi;
    
    public KetNoi()
    {
        cn = null;
        try 
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } 
        catch (ClassNotFoundException ex) 
        {
            JOptionPane.showMessageDialog(null, "Không tìm thấy gói: com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.exit(0);
        }
        chuoi_ket_noi = "jdbc:sqlserver://192.168.7.111:1362;DatabaseName=QLSV;UserName=ANHMATTROI;PassWord=anhmattroi";
    }
    
    public boolean Mo()
    {
        try
        {
            cn = DriverManager.getConnection(chuoi_ket_noi);
        }
        catch(SQLException loi)
        {
            return false;
        }
        return true;
    }
    
    public ResultSet LayDL(String str)
    {
        ResultSet bang = null;
        try
        {
            Statement lenh = this.cn.createStatement();
            bang = lenh.executeQuery(str);
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Câu lệnh truy vấn không đúng");
        }
        return bang;
    }
    
    public boolean CapNhat(String str)
    {
        try
        {
            Statement lenh = this.cn.createStatement();
            lenh.execute(str);
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Câu lệnh truy vấn không đúng");
            return false;
        }
        return true;
    }
    
    public void DongKetNoi()
    {
        if(this.cn != null)
        {
            try 
            {
                this.cn.close();
            } 
            catch (SQLException ex) 
            {
                //JOptionPane.showMessageDialog(null, ex.toString());
            }
        }
    }
}
