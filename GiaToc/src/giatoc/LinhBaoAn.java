
package giatoc;

import java.util.Scanner;

public class LinhBaoAn extends GiaToc{
    private int slChuyenXeBaoVeThanhCong;
    private int slSoi = 0;
    private int slGau = 0;
    private int SlHo = 0;
    
    @Override
    public void Nhap()throws SoLoaiException{
        super.Nhap();
        chungtoc = "Nguoi";
        nghenghiep = "Linh Bao An";
        System.out.print("Nhap so chuyen xe bao ve duoc: ");
        Scanner scan = new Scanner(System.in);
        slChuyenXeBaoVeThanhCong = Integer.parseInt(scan.nextLine());
        boolean exitcheck;
        int check = 0;
        do{
        System.out.print("Co giet duoc thu du hay khong? (0)Khong, (1)Co: ");
        try{
                check = Integer.parseInt(scan.nextLine());
                exitcheck = true;
                if(check < 0 || check > 1){
                    throw new SoLoaiException();
                }
            }
            catch(NumberFormatException e){
                exitcheck = false;
                System.out.println("So khong hop le !");
            }
            catch(SoLoaiException e){
                exitcheck = false;
                System.out.println(e.getMessage());
            }
        }while(exitcheck == false);
        int loai = 4;
        boolean exit = false;
        if(check == 1)
            do{
                System.out.print("Nhap loai thu giet duoc,(1)Soi, (2)Gau, (3)Ho, (0)Ket Thuc Viec Nhap:  ");
                try{
                    loai = Integer.parseInt(scan.nextLine());
                    if(loai < 0 || loai > 4){
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
                case 1: System.out.print("Nhap so luong Soi giet duoc: ");
                    try{
                        slSoi += Integer.parseInt(scan.nextLine());
                        if(slSoi < 0)
                            throw new SoLoaiException();
                    }
                    catch(SoLoaiException e){
                        System.out.println(e.getMessage());
                    }
                    catch(NumberFormatException e){
                        System.out.println("So khong hop le!");
                    }
                        break;
                case 2: System.out.print("Nhap so luong Gau giet duoc: ");
                    try{
                        slGau += Integer.parseInt(scan.nextLine());
                        if(slGau < 0)
                            throw new SoLoaiException();
                    }
                    catch(SoLoaiException e){
                        System.out.println(e.getMessage());
                    }
                    catch(NumberFormatException e){
                        System.out.println("So khong hop le!");
                    }
                        break;
                case 3: System.out.print("Nhap so luong Ho giet duoc: ");
                    try{
                        SlHo += Integer.parseInt(scan.nextLine());
                        if(SlHo < 0)
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
