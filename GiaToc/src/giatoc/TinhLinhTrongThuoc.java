package giatoc;

import java.util.Scanner;

public class TinhLinhTrongThuoc extends GiaToc{
    private int slCayTrong;
    @Override
    public void Nhap()throws SoLoaiException{
        super.Nhap();
        chungtoc = "Tinh Linh";
        nghenghiep = "Trong Thuoc";
        Scanner scan = new Scanner(System.in);
        do{
            System.out.print("Nhap so luong cay thuoc trong duoc: ");
            try{
                slCayTrong = Integer.parseInt(scan.nextLine());
                if(slCayTrong < 0){
                    throw new SoLoaiException();
                }
            }
            catch(NumberFormatException e){
                slCayTrong = -1;
                System.out.println("So khong hop le !");
            }
            catch(SoLoaiException e){
                System.out.println(e.getMessage());
            }
        } while(slCayTrong < 0);
    }
    @Override
    public void Xuat(){
        TinhTienThuong();
        TinhCuBet();
        TinhTienThuong();
        super.Xuat();
        System.out.print("  |Chung toc: " + chungtoc + "  |Nghe nghiep: " + nghenghiep);
        System.out.print("\nThanh qua lao dong: trong duoc " + slCayTrong + " cay thuoc");
        System.out.print("\nCubet: " + cubet + ", Diem cong hien: " + diemconghien + ", Tien thuong: " + tienthuong + ", Tong cong: " + tientongcong);
        System.out.print("\n-------------------------------------------------------------------------");
    }
    @Override
    protected void TinhDiemCH(){
        diemconghien = slCayTrong * 1;
    }
    @Override
    protected void TinhCuBet(){
        cubet = slCayTrong * 1 + tienthuong;
    }
}
