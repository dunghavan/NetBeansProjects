package giatoc;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class GiaToc {
    private  String mathanhvien;
    private String hoten;
    private String gioitinh;
    private String ngaysinh;
    private static final ArrayList<String> DSmatv = new ArrayList<String>();
    private boolean inputted;
    
    protected  String chungtoc;
    protected  String nghenghiep;
    protected int diemconghien;
    protected int cubet;
    protected int tienthuong;
    protected int tientongcong;
    
    public String getMTV(){
        return this.mathanhvien;
    }
    public String getGT(){
        return this.gioitinh;
    }
    public String getNS(){
        return this.ngaysinh;
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
        do{
            try{
                inputted = true;
                System.out.print("Nhap ma thanh vien: ");
                mathanhvien = scan.nextLine();
                CheckMTV();
            }
            catch(MaThanhVienException e){
                System.out.println(e.getMessage());
            }
            if(inputted == true)
                DSmatv.add(mathanhvien);
        }while(inputted == false);
        
        System.out.print("Nhap ho ten: ");
        hoten = scan.nextLine();
        do{
            try{
                inputted = true;
                System.out.print("Nhap gioi tinh: ");
                gioitinh = scan.nextLine();
                CheckGT();
            }
            catch(GioiTinhException e){
                System.out.println(e.getMessage());
            }
        } while(inputted == false);
        
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
