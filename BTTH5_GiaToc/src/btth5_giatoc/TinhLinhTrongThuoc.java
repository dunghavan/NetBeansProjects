package btth5_giatoc;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
        TinhCuBet();
        TinhTienThuong();
        super.Xuat();
        System.out.print("  |Chung toc: " + chungtoc + "  |Nghe nghiep: " + nghenghiep);
        System.out.print("\nThanh qua lao dong: trong duoc " + slCayTrong + " cay thuoc");
        System.out.print("\nCubet: " + cubet + ", Diem cong hien: " + diemconghien + ", Tien thuong: " + tienthuong + ", Thu nhap: " + tientongcong);
        System.out.print("\n-------------------------------------------------------------------------\n");
    }
   
    @Override
    public void Write() throws IOException{
        TinhTienThuong();
        TinhCuBet();
        TinhTienThuong();
        PrintWriter out = new PrintWriter(new BufferedWriter( new FileWriter("dsthanhvien.txt", true)));
        out.print("  |Chung toc: " + chungtoc + "  |Nghe nghiep: " + nghenghiep);
        out.print("\r\nCubet: " + cubet + ", Diem cong hien: " + diemconghien + ", Tien thuong: " + tienthuong + ", Thu nhap: " + tientongcong);
        out.print("\r\n-------------------------------------------------------------------------\r\n");
        out.close();
        PrintWriter p = new PrintWriter(new BufferedWriter( new FileWriter("thanhqualaodong.txt", true)));
        p.print("  MaTV: " + getMTV());
        p.print(" Thanh qua lao dong: trong duoc " + slCayTrong + " cay thuoc");
        p.print("\r\n--------------------------------------------------------------------------------------------\r\n");
        p.close();
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
