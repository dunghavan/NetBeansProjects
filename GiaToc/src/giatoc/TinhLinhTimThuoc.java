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
    
    /**
     *
     * @throws SoLoaiException
     */
    @Override
    public void Nhap()throws SoLoaiException{
        super.Nhap();
        chungtoc = "Tinh Linh";
        nghenghiep = "Tim Thuoc";
        int loai = 0;
        boolean exit = false;
        Scanner scan = new Scanner(System.in);
        do{
            System.out.print("Nhap loai thuoc tim duoc, hay nhap so tuong ung: (1)Linh Chi, (2)Ha Thu O, (3)Nhan Sam, (4)That Tam Lien, (0)Ket Thuc Viec Nhap...");
            try{
                loai = Integer.parseInt(scan.nextLine());
                if(loai < 0 || loai > 5){
                    throw new SoLoaiException();
                }
            }
            catch(NumberFormatException e){
                loai = 5;
                System.out.println("So khong hop le !");
            }
            catch(SoLoaiException e){
                System.out.println(e.getMessage());
            }
            switch(loai)
            {
                case 1:
                        System.out.print("Nhap so luong Linh Chi: ");
                        try{
                            slLinhChi += Integer.parseInt(scan.nextLine());
                            if(slLinhChi < 0)
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
                        System.out.print("Nhap so luong Ha Thu O: ");
                        try{
                            slHaThuO += Integer.parseInt(scan.nextLine());
                            if(slHaThuO < 0)
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
                        System.out.print("Nhap so luong Nhan Sam: ");
                        try{
                            slNhanSam += Integer.parseInt(scan.nextLine());
                            if(slNhanSam < 0)
                                throw new SoLoaiException();
                        }
                        catch(SoLoaiException e){
                            System.out.println(e.getMessage());
                        }
                        catch(NumberFormatException e){
                            System.out.println("So khong hop le!");
                        }
                        break;
                case 4:
                        System.out.print("Nhap so luong That Tam Lien: ");
                        try{
                            slThatTamLien += Integer.parseInt(scan.nextLine());
                            if(slThatTamLien < 0)
                                throw new SoLoaiException();
                        }
                        catch(SoLoaiException e){
                            System.out.println(e.getMessage());
                        }
                        catch(NumberFormatException e){
                            System.out.println("So khong hop le!");
                        }
                        break;
                case 5:
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
