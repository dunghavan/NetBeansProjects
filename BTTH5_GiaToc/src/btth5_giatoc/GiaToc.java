package btth5_giatoc;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public abstract class GiaToc {

    /**
     *
     */
    protected  String mathanhvien;
    protected String hoten;
    protected String gioitinh;
    protected String ngaysinh;
    private boolean inputted;
    private String[] DSmatv;
    
    protected  String chungtoc;
    protected  String nghenghiep;
    protected int diemconghien;
    protected int cubet;
    protected int tienthuong;
    protected int tientongcong;
    
    protected NewJFrame form;
    
    public String getMTV(){
        return this.mathanhvien;
    }
    public String getGT(){
        return this.gioitinh;
    }
    public String getNS(){
        return this.ngaysinh;
    }
    public GiaToc(){
        mathanhvien = main.frame.Get_JTextField_MaTV();
        hoten = main.frame.Get_JTextField_HoTen();
        gioitinh = main.frame.Get_JComboBox_GT();
        ngaysinh = main.frame.Get_JDateChooser();
    }
    public void CheckGT() throws GioiTinhException {
        if((!gioitinh.equalsIgnoreCase("nam")) && (!gioitinh.equalsIgnoreCase("nu"))){
            inputted = false;
            throw new GioiTinhException("Gioi tinh khong hop le!");
        }
    }
    public void CheckMTV() throws MaThanhVienException{
            for (String matv : DSmatv) {
                if(matv.equalsIgnoreCase(mathanhvien)){
                    inputted = false;
                    throw new MaThanhVienException("Ma thanh vien da ton tai!");
                }
            }
    }
    
    protected void Nhap()throws SoLoaiException{
        Scanner scan = new Scanner(System.in);

        mathanhvien = form.Get_JTextField_MaTV();
        hoten = form.Get_JTextField_HoTen();
        ngaysinh = form.Get_JDateChooser();
    }
    protected void Xuat(){
        System.out.print("  |Ma TV: " + mathanhvien);
        System.out.print("  |Ho ten: " + hoten);
        System.out.print("  |Gioi tinh: " + gioitinh);
        System.out.print("  |Ngay sinh: " + ngaysinh);
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
    
    abstract void Write() throws SQLException, IOException;
}
