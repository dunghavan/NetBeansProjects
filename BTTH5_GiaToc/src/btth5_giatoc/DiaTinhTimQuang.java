package btth5_giatoc;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class DiaTinhTimQuang extends GiaToc{
   private int slBichNgoc = 0;
   private int slLamNgoc = 0;
   private int slHongNgoc = 0;
   private int slKimCuong = 0;
   
   @Override
   public void Nhap()throws SoLoaiException{
        super.Nhap();
        chungtoc = "Dia Linh";
        nghenghiep = "Tim Quang";
        int loai = 0;
        boolean exit = false;
        Scanner scan = new Scanner(System.in);
        do{
            System.out.print("Nhap loai quang tim duoc, hay nhap so tuong ung: (1)Bich Ngoc, (2)Lam Ngoc, (3)Hong Ngoc, (4)Kim Cuong, (0)Ket Thuc Viec Nhap...");
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
                        System.out.print("Nhap so luong Bich Ngoc: ");
                        try{
                            slBichNgoc += Integer.parseInt(scan.nextLine());
                            if(slBichNgoc < 0)
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
                        System.out.print("Nhap so luong Lam Ngoc: ");
                        try{
                            slLamNgoc += Integer.parseInt(scan.nextLine());
                            if(slLamNgoc < 0)
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
                        System.out.print("Nhap so luong Hong Ngoc: ");
                        try{
                            slHongNgoc += Integer.parseInt(scan.nextLine());
                            if(slHongNgoc < 0)
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
                        System.out.print("Nhap so luong Kim Cuong: ");
                        try{
                            slKimCuong += Integer.parseInt(scan.nextLine());
                            if(slKimCuong < 0)
                                throw new SoLoaiException();
                        }
                        catch(SoLoaiException e){
                            System.out.println(e.getMessage());
                        }
                        catch(NumberFormatException e){
                            System.out.println("So khong hop le!");
                        }
                        break;
                case 5: break;
                case 0: exit = true;
            }
           } while(exit == false);
   }
   @Override
   public void Xuat(){
       try{
            DocFile();
        }
        catch(IOException e){
            System.out.println("Loi xay ra: " + e.getMessage());
        }
        TinhDiemCH();
        TinhCuBet();
        TinhTienThuong();
        super.Xuat();
        System.out.print("  |Chung toc: " + chungtoc + "  |Nghe nghiep: " + nghenghiep);
        System.out.print("\nThanh qua lao dong: Bich ngoc " + slBichNgoc + ", Lam ngoc " + slLamNgoc + ", Hong ngoc " + slHongNgoc + ", Kim cuong " + slKimCuong);
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
        p.print("   Thanh qua lao dong: Bich ngoc " + slBichNgoc + ", Lam ngoc " + slLamNgoc + ", Hong ngoc " + slHongNgoc + ", Kim cuong " + slKimCuong);
        p.print("\r\n--------------------------------------------------------------------------------------------\r\n");
        p.close();
    }
   @Override
    protected void TinhDiemCH(){
        diemconghien = slBichNgoc * giaBichNgoct + slLamNgoc * giaLamNgoc + slHongNgoc * giaHongNgoc + slKimCuong * giaKimCuong;
    }
    @Override
    protected void TinhCuBet(){
        TinhTienThuong();
         cubet = slBichNgoc * DCHBichNgoc + slLamNgoc * DCHLamNgoc + slHongNgoc * DCHHongNgoc + slKimCuong * DCHKimCuong + tienthuong;
    }
    private int giaBichNgoct, DCHBichNgoc;
    private int giaLamNgoc, DCHLamNgoc;
    private int giaHongNgoc, DCHHongNgoc;
    private int giaKimCuong, DCHKimCuong;
    public void DocFile() throws FileNotFoundException, IOException{
        // TODO code application logic here
        //Vi du doc du lieu tu file
        class Struct {
        private String ten = "";
        private String gia = "";
        private String DCH = "";
    }
        ArrayList<Struct> arr = new ArrayList<Struct>();
        FileReader in = new FileReader("banggiatimquang.txt");
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
            if(ob.ten.trim().equalsIgnoreCase("BichNgoc")){
                giaBichNgoct = Integer.parseInt(ob.gia);
                DCHBichNgoc = Integer.parseInt(ob.DCH.trim());
            }
            if(ob.ten.trim().equalsIgnoreCase("LamNgoc")){
                giaLamNgoc = Integer.parseInt(ob.gia);
                DCHLamNgoc = Integer.parseInt(ob.DCH.trim());
            }
            if(ob.ten.trim().equalsIgnoreCase("HongNgoc")){
                giaHongNgoc = Integer.parseInt(ob.gia);
                DCHHongNgoc = Integer.parseInt(ob.DCH.trim());
            }
            if(ob.ten.trim().equalsIgnoreCase("KimCuong")){
                giaKimCuong = Integer.parseInt(ob.gia);
                DCHKimCuong = Integer.parseInt(ob.DCH.trim());
            }
        }
    }
}
