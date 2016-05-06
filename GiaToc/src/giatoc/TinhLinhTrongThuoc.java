package giatoc;

import java.util.Scanner;

public class TinhLinhTrongThuoc extends GiaToc{
    private int slCayTrong;
    public void Nhap(){
        super.Nhap();
        chungtoc = "Tinh Linh";
        nghenghiep = "Trong Thuoc";
        Scanner scan = new Scanner(System.in);
        do{
            System.out.print("Nhap so luong cay thuoc trong duoc: ");
            slCayTrong = Integer.parseInt(scan.nextLine());
            if(slCayTrong < 0)
                System.out.print("So luong khong hop le! Nhap lai: ");
        } while(slCayTrong < 0);
    }
    public void Xuat(){
        TinhTienThuong();
        TinhTongCuBet();
        super.Xuat();
        System.out.print("  Chung toc: " + chungtoc + "  |Nghe nghiep: " + nghenghiep);
        System.out.print("\nThanh qua lao dong: trong duoc " + slCayTrong + " cay thuoc");
        System.out.print("\nCubet: " + cubet + ", Diem cong hien: " + diemconghien + ", Tien thuong: " + tienthuong + ", Tong cong: " + (cubet + tienthuong));
        System.out.print("\n-------------------------------------------------------------\n");
    }
    @Override
    protected void TinhDiemCH(){
        diemconghien = slCayTrong * 1;
    }
    @Override
    protected void TinhTienThuong(){
        TinhDiemCH();
        if(diemconghien >= 3000)
            tienthuong = 600;
        if(diemconghien > 2000 && diemconghien < 3000)
            tienthuong = 300;
    }
    @Override
    protected void TinhTongCuBet(){
        cubet = slCayTrong * 1 + tienthuong;
    }
}
