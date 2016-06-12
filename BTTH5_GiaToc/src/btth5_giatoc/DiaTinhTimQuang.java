package btth5_giatoc;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DiaTinhTimQuang extends GiaToc{
   
    public DiaTinhTimQuang() throws SoLuongException{
         chungtoc = main.frame.Get_ChungToc();
         nghenghiep =  main.frame.Get_NgheNghiep();
    }
   @Override
   public void Nhap(){
   }
   @Override
   public void Xuat(){
    }
   @Override
    public void Write() throws SQLException, SoLuongException, IOException {
        if(main.frame.Get_BichNgoc() < 0 || main.frame.Get_LamNgoc() < 0 || main.frame.Get_HongNgoc() < 0 || main.frame.Get_KimCuong() < 0){
            throw new SoLuongException("Số lượng quặng không hợp lệ");
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
                String TQLD = "Bích Ngọc: " + main.frame.Get_BichNgoc() + ", Lam Ngọc: " + main.frame.Get_LamNgoc()
                        + ", Hồng Ngọc: " + main.frame.Get_HongNgoc() + ", Kim Cương: " + main.frame.Get_KimCuong();
                String sql2 = "INSERT INTO ThanhQuaLaoDong VALUES(N'" + mathanhvien + "', N'" + TQLD + "')";
                sta.executeUpdate(sql2);
                
                main.frame.Set_Jlabel_Test("Đã lưu thành công!");
                GiaToc.DSmatv.add(mathanhvien);
            }
        }
    }
   @Override
    protected void TinhDiemCH(){
        diemconghien = main.frame.Get_BichNgoc() * giaBichNgoc + main.frame.Get_LamNgoc()* giaLamNgoc + main.frame.Get_HongNgoc()* giaHongNgoc + main.frame.Get_KimCuong() * giaKimCuong;
    }
    @Override
    protected void TinhCuBet(){
        TinhTienThuong();
         cubet = main.frame.Get_BichNgoc() * DCHBichNgoc + main.frame.Get_LamNgoc() * DCHLamNgoc + main.frame.Get_HongNgoc() * DCHHongNgoc + main.frame.Get_KimCuong() * DCHKimCuong + tienthuong;
    }
    private int giaBichNgoc = 0, DCHBichNgoc = 0;
    private int giaLamNgoc = 0, DCHLamNgoc = 0;
    private int giaHongNgoc = 0, DCHHongNgoc = 0;
    private int giaKimCuong = 0, DCHKimCuong = 0;
    
    private void DocCSDL() throws FileNotFoundException, IOException, SQLException{
        // Truy Van Du Lieu:
        Connection conn;
        conn = main.CreateConnection();
        Statement sta = conn.createStatement();
        ResultSet rs = sta.executeQuery("SELECT Name, Cost, Point FROM Quang");
        //Gan Du Lieu:
        while(rs.next())
        {
            String name = rs.getString(1);
            int cost = rs.getInt(2);
            int point = rs.getInt(3);
            if(name.equalsIgnoreCase("Bich Ngoc")){
                giaBichNgoc = cost;
                DCHBichNgoc = point;
            }
            if(name.equalsIgnoreCase("Lam Ngoc")){
                giaLamNgoc = cost;
                DCHLamNgoc = point;
            }
            if(name.equalsIgnoreCase("Hong Ngoc")){
                giaHongNgoc = cost;
                DCHHongNgoc = point;
            }
            if(name.equalsIgnoreCase("Kim Cuong")){
                giaKimCuong = cost;
                DCHKimCuong = point;
            }
        }
        conn.close();
        TinhCuBet();
        TinhDiemCH();
        TinhTienThuong();
    }
}
