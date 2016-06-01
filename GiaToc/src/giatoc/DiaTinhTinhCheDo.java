package giatoc;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
        System.out.print("\nThanh qua lao dong: Cong cu SX " + slCongCuSX + ", Vu khi " + slVuKhi + ", Ao giap " + slAoGiap);
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
        p.print("   Thanh qua lao dong: Cong cu SX " + slCongCuSX + ", Vu khi " + slVuKhi + ", Ao giap " + slAoGiap);
        p.print("\r\n--------------------------------------------------------------------------------------------\r\n");;
        p.close();
    }
   @Override
    protected void TinhDiemCH(){
        diemconghien = slCongCuSX * giaDCSanXuat + slVuKhi * giaVuKhi + slAoGiap * giaAoGiao;
    }
    @Override
    protected void TinhCuBet(){
        TinhTienThuong();
         cubet = slCongCuSX * DCHDCSanXuat + slVuKhi * DCHVuKhi + slAoGiap * DCHAoGiap + tienthuong;
    }
    private int giaDCSanXuat, DCHDCSanXuat;
    private int giaVuKhi, DCHVuKhi;
    private int giaAoGiao, DCHAoGiap;
    public void DocFile() throws FileNotFoundException, IOException{
        // TODO code application logic here
        //Vi du doc du lieu tu file
        class Struct {
        private String ten = "";
        private String gia = "";
        private String DCH = "";
    }
        ArrayList<Struct> arr = new ArrayList<Struct>();
        FileReader in = new FileReader("banggiatinhchedo.txt");
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
            if(ob.ten.trim().equalsIgnoreCase("DungCuSanXuat	")){
                giaDCSanXuat = Integer.parseInt(ob.gia);
                DCHDCSanXuat = Integer.parseInt(ob.DCH.trim());
            }
            if(ob.ten.trim().equalsIgnoreCase("VuKhi")){
                giaVuKhi = Integer.parseInt(ob.gia);
                DCHVuKhi = Integer.parseInt(ob.DCH.trim());
            }
            if(ob.ten.trim().equalsIgnoreCase("AoGiap")){
                giaAoGiao = Integer.parseInt(ob.gia);
                DCHAoGiap = Integer.parseInt(ob.DCH.trim());
            }
        }
    }
}
