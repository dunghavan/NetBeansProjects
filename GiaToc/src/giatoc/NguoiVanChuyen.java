package giatoc;

import java.util.Scanner;

public class NguoiVanChuyen extends GiaToc{
    private int slChuyenXe = 0;
    
    @Override
    public void Nhap(){
        super.Nhap();
        chungtoc = "Nguoi";
        nghenghiep = "Van Chuyen";
        System.out.print("Nhap so chuyen xe: ");
        Scanner scan = new Scanner(System.in);
        slChuyenXe += Integer.parseInt(scan.nextLine());
    }

    @Override
    public void Xuat(){
        TinhDiemCH();
        TinhCuBet();
        TinhTienThuong();
        super.Xuat();
        System.out.print("  |Chung toc: " + chungtoc + "  |Nghe nghiep: " + nghenghiep);
        System.out.print("\nThanh qua lao dong: Van chuyen duoc " + slChuyenXe + " chuyen xe.");
        System.out.print("\nCubet: " + cubet + ", Diem cong hien: " + diemconghien + ", Tien thuong: " + tienthuong + ", Tong cong: " + tientongcong);
        System.out.print("\n-------------------------------------------------------------------------");
    }
    @Override
    public void TinhDiemCH(){
        diemconghien = slChuyenXe * 1;
    }
    @Override
    public void TinhCuBet(){
        cubet = slChuyenXe * 1;
    }
}
