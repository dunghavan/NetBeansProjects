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
    
    public void Nhap() throws SoLoaiException{
        super.Nhap();
        chungtoc = "Dia Linh";
        nghenghiep = "Tinh Che Do";
        int loai = 0;
        boolean exit = false;
        Scanner scan = new Scanner(System.in);
        do{
            System.out.print("Nhap loai do tinh che duoc, hay nhap so tuong ung: (1)Cong Cu SX, (2)Vu Khi, (3)Ao Giap,(0)Ket Thuc Viec Nhap...");
            try{
                loai = Integer.parseInt(scan.nextLine());
                if(loai < 0 || loai > 3){
                    throw new SoLoaiException();
                }
            }
            catch(NumberFormatException e){
                loai = 4;
                System.out.println("So khong hop le !");
            }
            catch(SoLoaiException e){
                System.out.println(e.getMessage());
            }
            switch(loai)
            {
                case 1:
                        System.out.print("Nhap so luong Cong Cu SX: ");
                        try{
                            slCongCuSX += Integer.parseInt(scan.nextLine());
                            if(slCongCuSX < 0)
                                throw new SoLoaiException();
                        }
                        catch(SoLoaiException e){
                            System.out.println(e.getMessage());
                        }
                        catch(NumberFormatException e){
                            System.out.println("So khong hop le!");
                        }
                        break;
                case 2:
                        System.out.print("Nhap so luong Vu Khi: ");
                        try{
                            slVuKhi += Integer.parseInt(scan.nextLine());
                            if(slVuKhi < 0)
                                throw new SoLoaiException();
                        }
                        catch(SoLoaiException e){
                            System.out.println(e.getMessage());
                        }
                        catch(NumberFormatException e){
                            System.out.println("So khong hop le!");
                        }
                        break;
                case 3:
                        System.out.print("Nhap so luong Ao Giap: ");
                        try{
                            slAoGiap += Integer.parseInt(scan.nextLine());
                            if(slAoGiap < 0)
                                throw new SoLoaiException();
                        }
                        catch(SoLoaiException e){
                            System.out.println(e.getMessage());
                        }
                        catch(NumberFormatException e){
                            System.out.println("So khong hop le!");
                        }
                        break;
                case 4: break;
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
