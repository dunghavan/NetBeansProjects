/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package giatoc;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class TinhLinhTimThuoc extends GiaToc{
    private int slLinhChi = 0;
    private int slHaThuO = 0;
    private int slNhanSam = 0;
    private int slThatTamLien = 0;
    
    @Override
    public void Nhap(){
        super.Nhap();
        chungtoc = "Tinh Linh";
        nghenghiep = "Tim Thuoc";
        int loai;
        boolean exit = false;
        Scanner scan = new Scanner(System.in);
        do{
            System.out.print("Nhap loai thuoc tim duoc, hay nhap so tuong ung: (1)Linh Chi, (2)Ha Thu O, (3)Nhan Sam, (4)That Tam Lien, (0)Ket Thuc Viec Nhap...");
            loai = Integer.parseInt(scan.nextLine());  
            switch(loai)
            {
                case 1:
                        System.out.print("Nhap so luong Linh Chi: ");
                        slLinhChi += Integer.parseInt(scan.nextLine());
                        break;
                case 2:
                        System.out.print("Nhap so luong Ha Thu O: ");
                        slHaThuO += Integer.parseInt(scan.nextLine());
                        break;
                case 3:
                        System.out.print("Nhap so luong Nhan Sam: ");
                        slNhanSam += Integer.parseInt(scan.nextLine());
                        break;
                case 4:
                        System.out.print("Nhap so luong That Tam Lien: ");
                        slThatTamLien += Integer.parseInt(scan.nextLine());
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
        System.out.print("\nThanh qua lao dong: Linh chi x" + slLinhChi + ", Ha thu o x" + slHaThuO + ", Nhan sam x" + slNhanSam + ", That tam lien x" + slThatTamLien);
        System.out.print("\nCubet: " + cubet + ", Diem cong hien: " + diemconghien + ", Tien thuong: " + tienthuong + ", Tong cong: " + tientongcong);
        System.out.print("\n-------------------------------------------------------------------------");
    }
    @Override
    protected void TinhDiemCH(){
        diemconghien = slLinhChi * 5 + slHaThuO * 7 + slNhanSam * 10 + slThatTamLien * 20;
    }
    @Override
    protected void TinhCuBet(){
        TinhTienThuong();
         cubet = slLinhChi * 5 + slHaThuO * 7 + slNhanSam * 10 + slThatTamLien * 20 + tienthuong;
    }
}
