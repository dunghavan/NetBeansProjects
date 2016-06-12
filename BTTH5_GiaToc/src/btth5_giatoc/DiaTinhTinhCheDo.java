package btth5_giatoc;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author user
 */
public class DiaTinhTinhCheDo extends GiaToc{
    public DiaTinhTinhCheDo() throws SoLuongException{
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
   public void Write() throws IOException, SQLException, SoLuongException{
        if(main.frame.Get_CongCuSX() < 0 || main.frame.Get_VuKhi() < 0 || main.frame.Get_AoGiap() < 0){
            throw new SoLuongException("Số lượng đồ tinh chế không hợp lệ");
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
                String TQLD = "Công Cụ SX: " + main.frame.Get_CongCuSX() + ", Vũ Khí: " + main.frame.Get_VuKhi()
                        + ", Áo Giáp: " + main.frame.Get_AoGiap();
                String sql2 = "INSERT INTO ThanhQuaLaoDong VALUES(N'" + mathanhvien + "', N'" + TQLD + "')";
                sta.executeUpdate(sql2);
                
                main.frame.Set_Jlabel_Test("Đã lưu thành công!");
                GiaToc.DSmatv.add(mathanhvien);
            }
        }
    }
   @Override
    protected void TinhDiemCH(){
        diemconghien = main.frame.Get_CongCuSX() * giaDCSanXuat + main.frame.Get_VuKhi() * giaVuKhi + main.frame.Get_AoGiap() * giaAoGiao;
    }
    @Override
    protected void TinhCuBet(){
        TinhTienThuong();
         cubet = main.frame.Get_CongCuSX() * DCHDCSanXuat + main.frame.Get_VuKhi() * DCHVuKhi + main.frame.Get_AoGiap() * DCHAoGiap + tienthuong;
    }
    private int giaDCSanXuat = 0, DCHDCSanXuat = 0;
    private int giaVuKhi = 0, DCHVuKhi = 0;
    private int giaAoGiao = 0, DCHAoGiap = 0;
    private void DocCSDL() throws FileNotFoundException, IOException, SQLException{
        // Truy Van Du Lieu:
        Connection conn;
        conn = main.CreateConnection();
        Statement sta = conn.createStatement();
        ResultSet rs = sta.executeQuery("SELECT Name, Cost, Point FROM Do");
        //Gan Du Lieu:
        while(rs.next())
        {
            String name = rs.getString(1);
            int cost = rs.getInt(2);
            int point = rs.getInt(3);
            if(name.equalsIgnoreCase("CongCuSX")){
                giaDCSanXuat = cost;
                DCHDCSanXuat = point;
            }
            if(name.equalsIgnoreCase("Vu Khi")){
                giaVuKhi = cost;
                DCHVuKhi = point;
            }
            if(name.equalsIgnoreCase("Ao Giap")){
                giaAoGiao = cost;
                DCHAoGiap = point;
            }
        }
        conn.close();
        TinhCuBet();
        TinhDiemCH();
        TinhTienThuong();
    }
}
