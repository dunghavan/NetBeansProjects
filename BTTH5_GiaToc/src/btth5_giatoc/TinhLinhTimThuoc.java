/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package btth5_giatoc;

import java.sql.Statement;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author user
 */
public class TinhLinhTimThuoc extends GiaToc{
    public TinhLinhTimThuoc(){
        try{
            chungtoc = main.frame.Get_ChungToc();
            nghenghiep =  main.frame.Get_NgheNghiep();
            DocCSDL();
        }catch(IOException | SQLException  e){
            System.out.println("Loi Constructor: " + e.getMessage());
        }
    }
    @Override
    public void Xuat(){
        System.out.print("  |MaTV: " + mathanhvien + "  |Ho Ten: " + hoten + "  |Gioi Tinh: " + gioitinh + "    |Ngay Sinh: " + ngaysinh);
        System.out.print("  |Chung toc: " + chungtoc + "  |Nghe nghiep: " + nghenghiep);
        System.out.print("\nThanh qua lao dong: Linh chi " + main.frame.Get_LinhChi() + ", Ha thu o " + main.frame.Get_HaThuO() + ", Nhan sam " + main.frame.Get_NhanSam() + ", That tam lien " + main.frame.Get_ThatTamLien());
        System.out.print("\nCubet: " + cubet + ", Diem cong hien: " + diemconghien + ", Tien thuong: " + tienthuong + ", Thu nhap: " + tientongcong);
        System.out.print("\n-------------------------------------------------------------------------\n");
    }
    
    @Override
    public void Write() throws SQLException {
        Xuat();
        Connection conn = main.CreateConnection();
        Statement sta = conn.createStatement();
        //String sql = "INSERT INTO DSThanhVien VALUES('matv', 'hoten', 'c', 'd', 'e', 'f', 1, 2, 3, 4)"; 
        String sql = "INSERT INTO DSThanhVien VALUES('" + mathanhvien + "', '" + hoten + "', '" 
                + gioitinh + "', '" + ngaysinh + "', '" + chungtoc + "', '" + nghenghiep + "', "
                + cubet + ", " + diemconghien + ", " + tienthuong + ", " + tientongcong + ")";    
                //+ mathanhvien + "," + hoten + ","+ gioitinh + "," + ngaysinh + "," + chungtoc + ", "
                //+ nghenghiep + "," + cubet + "," + diemconghien + "," + tienthuong + "," + tientongcong + ")";
        int num = sta.executeUpdate(sql);
        main.frame.Set_Jlabel_Test("Da ghi");
        
    }
    @Override
    protected void TinhDiemCH(){
        diemconghien =  main.frame.Get_LinhChi() * giaLinhChi 
                +  main.frame.Get_HaThuO() * giaHaThuO +  main.frame.Get_NhanSam() * giaNhanSam 
                +  main.frame.Get_ThatTamLien() * giaThatTamLien;
    }
    @Override
    protected void TinhCuBet(){
        TinhTienThuong();
        cubet =  main.frame.Get_LinhChi() * DCHLinhChi 
                 +  main.frame.Get_HaThuO() * DCHHaThuO 
                 +  main.frame.Get_NhanSam() * DCHNhanSam +  main.frame.Get_ThatTamLien() * DCHThatTamLien + tienthuong;
    }
    private int giaLinhChi = 0, DCHLinhChi = 0;
    private int giaHaThuO = 0,DCHHaThuO = 0;
    private int giaNhanSam = 0, DCHNhanSam = 0;
    private int giaThatTamLien = 0, DCHThatTamLien = 0;

    private void DocCSDL() throws FileNotFoundException, IOException, SQLException{
        // Truy Van Du Lieu:
        Connection conn;
        conn = main.CreateConnection();
        Statement sta = conn.createStatement();
        ResultSet rs = sta.executeQuery("SELECT Name, Cost, Point FROM Thuoc");
        //Gan Du Lieu:
        while(rs.next())
        {
            String name = rs.getString(1);
            int cost = rs.getInt(2);
            int point = rs.getInt(3);
            if(name.equalsIgnoreCase("Linh Chi")){
                giaLinhChi = cost;
                DCHLinhChi = point;
            }
            if(name.equalsIgnoreCase("Ho Thu O")){
                giaHaThuO = cost;
                DCHHaThuO = point;
            }
            if(name.equalsIgnoreCase("Nhan Sam")){
                giaNhanSam = cost;
                DCHNhanSam = point;
            }
            if(name.equalsIgnoreCase("That Tam Lien")){
                giaThatTamLien = cost;
                DCHThatTamLien = point;
        }
        }
        conn.close();
        TinhCuBet();
        TinhDiemCH();
        TinhTienThuong();
    }
}
