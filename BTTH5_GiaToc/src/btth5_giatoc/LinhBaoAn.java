
package btth5_giatoc;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LinhBaoAn extends GiaToc{
    public LinhBaoAn() throws SoLuongException{
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
        if(main.frame.Get_SLChuyenXeBaoVe() < 0 || main.frame.Get_Soi() < 0 || main.frame.Get_Gau() < 0 || main.frame.Get_Ho() < 0){
            throw new SoLuongException("Số lượng thú dữ không hợp lệ");
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
                String TQLD = "Bảo vệ được: " + main.frame.Get_SLChuyenXeBaoVe() + " chuyến xe" + ", Giết được: " + main.frame.Get_Soi() + " sói, "
                        + main.frame.Get_Gau() + " gấu, " + main.frame.Get_Ho() + " hổ";
                String sql2 = "INSERT INTO ThanhQuaLaoDong VALUES(N'" + mathanhvien + "', N'" + TQLD + "')";
                sta.executeUpdate(sql2);
                
                main.frame.Set_Jlabel_Test("Đã lưu thành công!");
                GiaToc.DSmatv.add(mathanhvien);
            }
        }
    }
    @Override
    public void TinhDiemCH(){
        diemconghien = main.frame.Get_SLChuyenXeBaoVe() * 1 + main.frame.Get_Soi() * giaSoi + main.frame.Get_Gau() * giaGau + main.frame.Get_Ho() * giaHo;
    }
    @Override
    public void TinhCuBet(){
        cubet = main.frame.Get_SLChuyenXeBaoVe() * 1 + main.frame.Get_Soi() * DCHSoi + main.frame.Get_Gau() * DCHGau + main.frame.Get_Ho() * DCHHo;
    }
    private int giaSoi = 0, DCHSoi = 0;
    private int giaGau = 0,DCHGau = 0;
    private int giaHo = 0, DCHHo = 0;

    private void DocCSDL() throws FileNotFoundException, IOException, SQLException{
        // Truy Van Du Lieu:
        Connection conn;
        conn = main.CreateConnection();
        Statement sta = conn.createStatement();
        ResultSet rs = sta.executeQuery("SELECT Name, Cost, Point FROM ThuDu");
        //Gan Du Lieu:
        while(rs.next())
        {
            String name = rs.getString(1);
            int cost = rs.getInt(2);
            int point = rs.getInt(3);
            if(name.equalsIgnoreCase("Soi")){
                giaSoi = cost;
                DCHSoi = point;
            }
            if(name.equalsIgnoreCase("Gau")){
                giaGau = cost;
                DCHGau = point;
            }
            if(name.equalsIgnoreCase("Ho")){
                giaHo = cost;
                DCHHo = point;
            }
        }
        conn.close();
        TinhCuBet();
        TinhDiemCH();
        TinhTienThuong();
    }
}
