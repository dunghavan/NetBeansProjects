package giatoc;

import java.util.Scanner;

public abstract class GiaToc {
    private  String mathanhvien;
    private String hoten;
    private String gioitinh;
    private String ngaysinh;
    protected  String chungtoc;
    protected  String nghenghiep;
    
    protected int diemconghien;
    protected int cubet;
    protected int tienthuong;
    protected int tientongcong;
    
    protected void Nhap(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Nhap ma so: ");
        mathanhvien = scan.nextLine();
        System.out.print("Nhap ho ten: ");
        hoten = scan.nextLine();
        System.out.print("Nhap gioi tinh: ");
        gioitinh = scan.nextLine();
        System.out.print("Nhap ngay sinh: ");
        ngaysinh = scan.nextLine();
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
}
