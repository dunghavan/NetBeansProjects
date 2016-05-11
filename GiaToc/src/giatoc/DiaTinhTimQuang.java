package giatoc;

import java.util.Scanner;


public class DiaTinhTimQuang extends GiaToc{
   private int slBichNgoc = 0;
   private int slLamNgoc = 0;
   private int slHongNgoc = 0;
   private int slKimCuong = 0;
   
   @Override
   public void Nhap(){
        super.Nhap();
        chungtoc = "Dia Linh";
        nghenghiep = "Tim Quang";
        int loai;
        boolean exit = false;
        Scanner scan = new Scanner(System.in);
        do{
            System.out.print("Nhap loai quang tim duoc, hay nhap so tuong ung: (1)Bich Ngoc, (2)Lam Ngoc, (3)Hong Ngoc, (4)Kim Cuong, (0)Ket Thuc Viec Nhap...");
            loai = Integer.parseInt(scan.nextLine());  
            switch(loai)
            {
                case 1:
                        System.out.print("Nhap so luong Bich Ngoc: ");
                        slBichNgoc += Integer.parseInt(scan.nextLine());
                        break;
                case 2:
                        System.out.print("Nhap so luong Lam Ngoc: ");
                        slLamNgoc += Integer.parseInt(scan.nextLine());
                        break;
                case 3:
                        System.out.print("Nhap so luong Hong Ngoc: ");
                        slHongNgoc += Integer.parseInt(scan.nextLine());
                        break;
                case 4:
                        System.out.print("Nhap so luong Kim Cuong: ");
                        slKimCuong += Integer.parseInt(scan.nextLine());
                        break;
                case 0: exit = true;
            }
           } while(exit == false);
   }
   @Override
   public void Xuat(){
        TinhDiemCH();
        TinhCuBet();
        TinhTienThuong();
        super.Xuat();
        System.out.print("  |Chung toc: " + chungtoc + "  |Nghe nghiep: " + nghenghiep);
        System.out.print("\nThanh qua lao dong: Bich ngoc x" + slBichNgoc + ", Lam ngoc x" + slLamNgoc + ", Hong ngoc x" + slHongNgoc + ", Kim cuong x" + slKimCuong);
        System.out.print("\nCubet: " + cubet + ", Diem cong hien: " + diemconghien + ", Tien thuong: " + tienthuong + ", Tong cong: " + tientongcong);
        System.out.print("\n-------------------------------------------------------------------------");
    }
   @Override
    protected void TinhDiemCH(){
        diemconghien = slBichNgoc * 5 + slLamNgoc * 10 + slHongNgoc * 15 + slKimCuong * 20;
    }
    @Override
    protected void TinhCuBet(){
        TinhTienThuong();
         cubet = slBichNgoc * 5 + slLamNgoc * 10 + slHongNgoc * 15 + slKimCuong * 20 + tienthuong;
    }
}
