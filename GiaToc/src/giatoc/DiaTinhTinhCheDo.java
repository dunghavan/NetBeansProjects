package giatoc;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class DiaTinhTinhCheDo extends GiaToc{
    private int slCongCuSX = 0;
    private int slVuKhi = 0;
    private int slAoGiap = 0;
    
    public void Nhap(){
        super.Nhap();
        chungtoc = "Dia Linh";
        nghenghiep = "Tinh Che Do";
        int loai;
        boolean exit = false;
        Scanner scan = new Scanner(System.in);
        do{
            System.out.print("Nhap loai do tinh che duoc, hay nhap so tuong ung: (1)Cong Cu SX, (2)Vu Khi, (3)Ao Giap,(0)Ket Thuc Viec Nhap...");
            loai = Integer.parseInt(scan.nextLine());  
            switch(loai)
            {
                case 1:
                        System.out.print("Nhap so luong Cong Cu SX: ");
                        slCongCuSX += Integer.parseInt(scan.nextLine());
                        break;
                case 2:
                        System.out.print("Nhap so luong Vu Khi: ");
                        slVuKhi += Integer.parseInt(scan.nextLine());
                        break;
                case 3:
                        System.out.print("Nhap so luong Ao Giap: ");
                        slAoGiap += Integer.parseInt(scan.nextLine());
                        break;
                case 0: exit = true;
            }
           } while(exit == false);
   }
   public void Xuat(){
        TinhDiemCH();
        TinhCuBet();
        TinhTienThuong();
        super.Xuat();
        System.out.print("  |Chung toc: " + chungtoc + "  |Nghe nghiep: " + nghenghiep);
        System.out.print("\nThanh qua lao dong: Cong cu SX x" + slCongCuSX + ", Vu khi x" + slVuKhi + ", Ao giap x" + slAoGiap);
        System.out.print("\nCubet: " + cubet + ", Diem cong hien: " + diemconghien + ", Tien thuong: " + tienthuong + ", Tong cong: " + tientongcong);
        System.out.print("\n-------------------------------------------------------------------------");
    }
   @Override
    protected void TinhDiemCH(){
        diemconghien = slCongCuSX * 1 + slVuKhi * 2 + slAoGiap * 3;
    }
    @Override
    protected void TinhCuBet(){
        TinhTienThuong();
         cubet = slCongCuSX * 1 + slVuKhi * 2 + slAoGiap * 3 + tienthuong;
    }
}
