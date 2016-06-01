
package giatoc;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
        System.out.print("\nThanh qua lao dong: Bao ve duoc " + slChuyenXeBaoVeThanhCong + " chuyen xe, giet duoc " + slSoi + " soi, " + slGau + " gau, " + SlHo + " ho");
        System.out.print("\nCubet: " + cubet + ", Diem cong hien: " + diemconghien + ", Tien thuong: " + tienthuong + ", Thu nhap: " + tientongcong);
        System.out.print("\n-------------------------------------------------------------------------\n");
    }
    @Override
    public void Write() throws IOException{
        TinhDiemCH();
        TinhCuBet();
        TinhTienThuong();
        super.Write();
        PrintWriter out = new PrintWriter(new BufferedWriter( new FileWriter("dsthanhvien.txt", true)));
        out.print("  |Chung toc: " + chungtoc + "  |Nghe nghiep: " + nghenghiep);
        out.print("\r\nCubet: " + cubet + ", Diem cong hien: " + diemconghien + ", Tien thuong: " + tienthuong + ", Thu nhap: " + tientongcong);
        out.print("\r\n-------------------------------------------------------------------------\r\n");
        out.close();
        PrintWriter p = new PrintWriter(new BufferedWriter( new FileWriter("thanhqualaodong.txt", true)));
        p.print("  MaTV: " + getMTV());
        p.print("   Thanh qua lao dong: Bao ve duoc " + slChuyenXeBaoVeThanhCong + " chuyen xe, giet duoc " + slSoi + " soi, " + slGau + " gau, " + SlHo + " ho");
        p.print("\r\n--------------------------------------------------------------------------------------------\r\n");
        p.close();
    }
    @Override
    public void TinhDiemCH(){
        diemconghien = slChuyenXeBaoVeThanhCong * 1 + slSoi * giaSoi + slGau * giaGau + SlHo * giaHo;
    }
    @Override
    public void TinhCuBet(){
        cubet = diemconghien;
    }
    private int giaSoi, DCHSoi;
    private int giaGau,DCHGau;
    private int giaHo, DCHHo;

    public void DocFile() throws FileNotFoundException, IOException{
        // TODO code application logic here
        //Vi du doc du lieu tu file
        class Struct {
        private String ten = "";
        private String gia = "";
        private String DCH = "";
    }
        ArrayList<Struct> arr = new ArrayList<Struct>();
        FileReader in = new FileReader("banggiathudu.txt");
        char[] a = new char[300];
        in.read(a);
        Struct object = new Struct();
        int tab = 0;
        for(int i = 0; i < a.length; i++){
            if (tab == 0)
            {
                if(String.valueOf(a[i]).equals("\t")){ 
                    tab = 1; i++;}
                else
                    object.ten += String.valueOf(a[i]);
            }
            if(tab == 1){
                if(String.valueOf(a[i]).equals("\t")){ tab = 2; i++;}
                else
                    object.gia += String.valueOf(a[i]);
            }
            if(tab == 2){
                if(String.valueOf(a[i]).equals("\n")){
                    arr.add(object);
                    object = new Struct();
                    tab = 0;
                } else
                    if(String.valueOf(a[i]) == null){
                    arr.add(object);
                    object = new Struct();
                    } else
                        object.DCH += String.valueOf(a[i]);
            }
        }
        for(Struct ob: arr){
            if(ob.ten.trim().equalsIgnoreCase("Soi")){
                giaSoi = Integer.parseInt(ob.gia);
                DCHSoi = Integer.parseInt(ob.DCH.trim());
            }
            if(ob.ten.trim().equalsIgnoreCase("Gau")){
                giaGau = Integer.parseInt(ob.gia);
                DCHGau = Integer.parseInt(ob.DCH.trim());
            }
            if(ob.ten.trim().equalsIgnoreCase("Ho")){
                giaHo = Integer.parseInt(ob.gia);
                DCHHo = Integer.parseInt(ob.DCH.trim());
            }
        }
        //in.close();
    }
}
