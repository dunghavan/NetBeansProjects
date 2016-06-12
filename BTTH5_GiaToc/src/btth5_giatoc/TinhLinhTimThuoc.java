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
    public TinhLinhTimThuoc() throws SoLuongException{
            chungtoc = main.frame.Get_ChungToc();
            nghenghiep =  main.frame.Get_NgheNghiep();
    }
    @Override
    public void Xuat(){
    }
    
    @Override
    public void Write() throws SQLException, SoLuongException, IOException {
        Xuat();
        if(main.frame.Get_LinhChi() < 0 || main.frame.Get_HaThuO() < 0 || main.frame.Get_NhanSam() < 0 
                || main.frame.Get_ThatTamLien() < 0){
            throw new SoLuongException("Số lượng thuốc không hợp lệ");
        }
        else{
            if(MaTV_HopLe == true){
                DocCSDL();
                Connection conn = main.CreateConnection();
                Statement sta = conn.createStatement();
                //String sql = "INSERT INTO DSThanhVien VALUES('a', 'b', 'c', 'd', 'e', 'f', 1, 2, 3, 4)"; 
                String sql = "INSERT INTO DSThanhVien VALUES(N'" + mathanhvien + "', N'" + hoten + "', N'" 
                        + gioitinh + "', N'" + ngaysinh + "', N'" + chungtoc + "', N'" + nghenghiep + "', "
                        + cubet + ", " + diemconghien + ", " + tienthuong + ", " + tientongcong + ")";
                sta.executeUpdate(sql);
                //
                String TQLD = "Linh Chi: " + main.frame.Get_LinhChi() + ", Hà Thủ Ô: " + main.frame.Get_HaThuO()
                        + ", Nhân Sâm: " + main.frame.Get_NhanSam() + ", Thất Tâm Liên: " + main.frame.Get_ThatTamLien();
                String sql2 = "INSERT INTO ThanhQuaLaoDong VALUES(N'" + mathanhvien + "', N'" + TQLD + "')";
                sta.executeUpdate(sql2);
                
                main.frame.Set_Jlabel_Test("Đã lưu thành công!");
                GiaToc.DSmatv.add(mathanhvien);
                conn.close();
            }
        }
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
    private int giaLinhChi, DCHLinhChi;
    private int giaHaThuO,DCHHaThuO;
    private int giaNhanSam, DCHNhanSam;
    private int giaThatTamLien, DCHThatTamLien;

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

