
package giatoc;

import java.util.Scanner;

public class LinhBaoAn extends GiaToc{
    private int slChuyenXeBaoVeThanhCong;
    private int slSoi = 0;
    private int slGau = 0;
    private int SlHo = 0;
    
    @Override
    public void Nhap(){
        super.Nhap();
        chungtoc = "Nguoi";
        nghenghiep = "Linh Bao An";
        System.out.print("Nhap so chuyen xe bao ve duoc: ");
        Scanner scan = new Scanner(System.in);
        slChuyenXeBaoVeThanhCong = Integer.parseInt(scan.nextLine());
        System.out.print("Co giet duoc thu du hay khong? (0)Khong, (1)Co: ");
        int check = Integer.parseInt(scan.nextLine());
        int loai;
        boolean exit = false;
        if(check == 1)
            do{
                System.out.print("Nhap loai thu giet duoc,(1)Soi, (2)Gau, (3)Ho, (0)Ket Thuc Viec Nhap:  ");
                loai = Integer.parseInt(scan.nextLine());
                switch(loai)
                {
                    case 1: System.out.print("Nhap so luong Soi giet duoc: ");
                            slSoi += Integer.parseInt(scan.nextLine());
                            break;
                    case 2: System.out.print("Nhap so luong Soi giet duoc: ");
                            slGau += Integer.parseInt(scan.nextLine());
                            break;
                    case 3: System.out.print("Nhap so luong Soi giet duoc: ");
                            SlHo += Integer.parseInt(scan.nextLine());
                            break;
                    case 0: exit = true;
                }
            } while(exit == false);
        else{}
    }
    @Override
    public void Xuat(){
        TinhDiemCH();
        TinhCuBet();
        TinhTienThuong();
        super.Xuat();
        System.out.print("  |Chung toc: " + chungtoc + "  |Nghe nghiep: " + nghenghiep);
        System.out.print("\nThanh qua lao dong: Bao ve duoc " + slChuyenXeBaoVeThanhCong + " chuyen xe, giet duoc " + slSoi + " soi, " + slGau + " gau, " + SlHo + " ho.");
        System.out.print("\nCubet: " + cubet + ", Diem cong hien: " + diemconghien + ", Tien thuong: " + tienthuong + ", Tong cong: " + tientongcong);
        System.out.print("\n-------------------------------------------------------------------------");
    }
    @Override
    public void TinhDiemCH(){
        diemconghien = slChuyenXeBaoVeThanhCong * 1 + slSoi * 2 + slGau * 3 + SlHo * 4;
    }
    @Override
    public void TinhCuBet(){
        cubet = diemconghien;
    }
}
