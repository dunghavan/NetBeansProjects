package btth5_giatoc;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class NguoiVanChuyen extends GiaToc{
    private int slChuyenXe = 0;
    
    @Override
    public void Nhap()throws SoLoaiException{
        super.Nhap();
        chungtoc = "Nguoi";
        nghenghiep = "Van Chuyen";
        Scanner scan = new Scanner(System.in);
        do{
            System.out.print("Nhap so chuyen xe: ");
            try{
                slChuyenXe = Integer.parseInt(scan.nextLine());
                if(slChuyenXe < 0){
                    throw new SoLoaiException();
                }
            }
            catch(NumberFormatException e){
                System.out.println("So khong hop le !");
            }
            catch(SoLoaiException e){
                System.out.println(e.getMessage());
            }
        }while(slChuyenXe < 0);
    }
    @Override
    public void Xuat(){
        TinhDiemCH();
        TinhCuBet();
        TinhTienThuong();
        super.Xuat();
        System.out.print("  |Chung toc: " + chungtoc + "  |Nghe nghiep: " + nghenghiep);
        System.out.print("\nThanh qua lao dong: Van chuyen duoc " + slChuyenXe + " chuyen xe.");
        System.out.print("\nCubet: " + cubet + ", Diem cong hien: " + diemconghien + ", Tien thuong: " + tienthuong + ", Thu nhap: " + tientongcong);
        System.out.print("\n-------------------------------------------------------------------------\n");
    }
    
    @Override
    public void Write() throws IOException{
        TinhDiemCH();
        TinhCuBet();
        TinhTienThuong();
        PrintWriter out = new PrintWriter(new BufferedWriter( new FileWriter("dsthanhvien.txt", true)));
        out.print("  |Chung toc: " + chungtoc + "  |Nghe nghiep: " + nghenghiep);
        out.print("\r\nCubet: " + cubet + ", Diem cong hien: " + diemconghien + ", Tien thuong: " + tienthuong + ", Thu nhap: " + tientongcong);
        out.print("\r\n-------------------------------------------------------------------------\r\n");
        out.close();
        PrintWriter p = new PrintWriter(new BufferedWriter( new FileWriter("thanhqualaodong.txt", true)));
        p.print("  MaTV: " + getMTV());
        p.print("   Thanh qua lao dong: Van chuyen duoc " + slChuyenXe + " chuyen xe.");
        p.print("\r\n--------------------------------------------------------------------------------------------\r\n");
        p.close();
    }
    @Override
    public void TinhDiemCH(){
        diemconghien = slChuyenXe * 1;
    }
    @Override
    public void TinhCuBet(){
        cubet = slChuyenXe * 1;
    }
}
