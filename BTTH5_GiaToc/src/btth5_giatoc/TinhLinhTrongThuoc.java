package btth5_giatoc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TinhLinhTrongThuoc extends GiaToc{
    public TinhLinhTrongThuoc() throws SoLuongException{
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
    public void Write() throws SQLException, SoLuongException , IOException{
        if(main.frame.Get_SLCayThuoc() < 0){
            throw new SoLuongException("Số lượng cây thuốc không hợp lệ");
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
                main.frame.Set_Jlabel_Test("Đã lưu thành công!");
                GiaToc.DSmatv.add(mathanhvien);
            }
        }
    }
    @Override
    protected void TinhDiemCH(){
        diemconghien = main.frame.Get_SLCayThuoc() * 1;
    }
    @Override
    protected void TinhCuBet(){
        cubet = main.frame.Get_SLCayThuoc() * 1 + tienthuong;
    } 
    private void DocCSDL() throws IOException, SQLException{
        TinhCuBet();
        TinhDiemCH();
        TinhTienThuong();
    }
}
