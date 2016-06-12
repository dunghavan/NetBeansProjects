package btth5_giatoc;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public abstract class GiaToc {

    /**
     *
     */
    protected  String mathanhvien;
    protected String hoten;
    protected String gioitinh;
    protected String ngaysinh;
    protected static final ArrayList<String> DSmatv = new ArrayList<>();
    static boolean MaTV_HopLe = true;
    
    protected  String chungtoc;
    protected  String nghenghiep;
    protected int diemconghien;
    protected int cubet;
    protected int tienthuong;
    protected int tientongcong;
    
    protected NewJFrame form;
//    
//    public String getMTV(){
//        return this.mathanhvien;
//    }
//    public String getGT(){
//        return this.gioitinh;
//    }
//    public String getNS(){
//        return this.ngaysinh;
//    }
    public GiaToc() throws SoLuongException{
        mathanhvien = main.frame.Get_JTextField_MaTV();
        if(mathanhvien.equalsIgnoreCase(""))
            throw new SoLuongException("Hãy nhập mã thành viên!");
        else{
            try {
                CheckMTV();
            } catch (MaThanhVienException ex) {
                JOptionPane.showMessageDialog(null, "Mã Thành Viên Đã Tồn Tại", "Lỗi!!!", 1);
            }
        }
        hoten = main.frame.Get_JTextField_HoTen();
        if(hoten.equalsIgnoreCase(""))
            throw new SoLuongException("Hãy nhập họ tên!");
        gioitinh = main.frame.Get_JComboBox_GT();
        ngaysinh = main.frame.Get_JDateChooser();
        if(ngaysinh.equalsIgnoreCase(""))
            throw new SoLuongException("Hãy chọn ngày sinh!");
    }
    private void CheckMTV() throws MaThanhVienException{
            for (String matv : DSmatv) {
                if(matv.equalsIgnoreCase(mathanhvien)){
                    MaTV_HopLe = false;
                    throw new MaThanhVienException("Mã thành viên đã tồn tại!");
                }
            }
    }
    
    protected void Nhap(){
    }
    protected void Xuat(){
    }
    abstract void TinhDiemCH();
    protected  void TinhTienThuong(){
        if(diemconghien >= 3000)
            tienthuong = 600;
        if(diemconghien > 2000 && diemconghien < 3000)
            tienthuong = 300;
        tientongcong = cubet + tienthuong;
    };
    abstract void TinhCuBet();
    
    abstract void Write() throws SQLException, IOException, SoLuongException;
}
