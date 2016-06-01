package giatoc;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class main {
    protected ArrayList <GiaToc> List = new ArrayList<GiaToc>();
    public  static void main(String []args) throws SoLoaiException, IOException{
        ArrayList <GiaToc> List = new ArrayList<GiaToc>();
        int loaichungtoc = 0;
        int loainghengiep;
        boolean exit = false;
        boolean exit2;
        boolean chen = false;
        GiaToc tv;
        Scanner scan = new Scanner(System.in);
        do
        {
            System.out.print("---------------------------------------------------\n");
            System.out.print("Ban muon nhap thanh vien loai nao? (1)Tinh Linh, (2)Dia Tinh, (3)Nguoi, (0)Ket thuc viec nhap: ");
            try{
                loaichungtoc = Integer.parseInt(scan.nextLine());
            }
            catch (NumberFormatException e) {
                System.out.println("Loai chung toc khong hop le.");
            }
            switch(loaichungtoc)
            {
                case 1: do
                        {   
                            exit2 = false;
                            System.out.print("Tinh linh thuoc loai nao? (1)Tim Thuoc, (2)Trong Thuoc: ");
                            loainghengiep = Integer.parseInt(scan.nextLine());
                            if(loainghengiep == 1){
                                System.out.print("Nhap thong tin cho Tinh Linh Tim Thuoc: ");
                                tv = new TinhLinhTimThuoc();
                                tv.Nhap();
                                tv.TinhDiemCH();
                                tv.TinhCuBet();
                                tv.TinhTienThuong();
                                if(List.size() < 1)
                                    List.add(tv);
                                else{
                                    for(int i = 0; i < List.size(); i++)
                                        if(tv.tientongcong >= List.get(i).tientongcong)
                                        {
                                            List.add(i, tv);
                                            chen = true;
                                            break;
                                        }
                                if(chen == false)
                                    List.add(tv);
                                }
                                exit2 = true;
                            }
                            if(loainghengiep == 2){
                                System.out.print("Nhap thong tin cho Tinh Linh Trong Thuoc: ");
                                tv = new TinhLinhTrongThuoc();
                                tv.Nhap();
                                tv.TinhDiemCH();
                                tv.TinhCuBet();
                                tv.TinhTienThuong();
                                if(List.size() < 1)
                                    List.add(tv);
                                else{
                                    for(int i = 0; i < List.size(); i++)
                                        if(tv.tientongcong >= List.get(i).tientongcong)
                                        {
                                            List.add(i, tv);
                                            chen = true;
                                            break;
                                        }
                                if(chen == false)
                                    List.add(tv);
                                }
                                exit2 = true;
                            }
                            if(loainghengiep != 1 && loainghengiep != 2)
                                System.out.print("Khong hop le, hay nhap lai! ");
                        }while(exit2 == false);
                        break;
                case 2: do
                        {
                            exit2 = false;
                            System.out.print("Dia Tinh thuoc loai nao? (1)Tim Quang, (2)Tinh Che Do: ");
                            loainghengiep = Integer.parseInt(scan.nextLine());
                            if(loainghengiep == 1){
                                System.out.print("Nhap thong tin cho Dia Tinh tim quang: ");
                                tv = new DiaTinhTimQuang();
                                tv.Nhap();
                                tv.TinhDiemCH();
                                tv.TinhCuBet();
                                tv.TinhTienThuong();
                                if(List.size() < 1)
                                    List.add(tv);
                                else{
                                    for(int i = 0; i < List.size(); i++)
                                        if(tv.tientongcong >= List.get(i).tientongcong)
                                        {
                                            List.add(i, tv);
                                            chen = true;
                                            break;
                                        }
                                if(chen == false)
                                    List.add(tv);
                                }
                                exit2 = true;
                            }
                            if(loainghengiep == 2){
                                System.out.print("Nhap thong tin cho Dia Tinh tinh che do: ");
                                tv = new DiaTinhTinhCheDo();
                                tv.Nhap();
                                tv.TinhDiemCH();
                                tv.TinhCuBet();
                                tv.TinhTienThuong();
                                if(List.size() < 1)
                                    List.add(tv);
                                else{
                                    for(int i = 0; i < List.size(); i++)
                                        if(tv.tientongcong >= List.get(i).tientongcong)
                                        {
                                            List.add(i, tv);
                                            chen = true;
                                            break;
                                        }
                                if(chen == false)
                                    List.add(tv);
                                }
                                exit2 = true;
                            }
                            if(loainghengiep != 1 && loainghengiep != 2)
                                System.out.print("Khong hop le, hay nhap lai! ");
                        }while(exit2 == false);
                        break;
                case 3: do
                        {
                            exit2 = false;
                            System.out.print("Nguoi thuoc loai nao? (1)Nguoi Van Chuyen, (2)Linh Bao An: ");
                            loainghengiep = Integer.parseInt(scan.nextLine());
                            if(loainghengiep == 1){
                                System.out.print("Nhap thong tin cho Nguoi van chuyen: ");
                                tv = new NguoiVanChuyen();
                                tv.Nhap();
                                tv.TinhDiemCH();
                                tv.TinhCuBet();
                                tv.TinhTienThuong();
                                if(List.size() < 2)
                                    List.add(tv);
                                else{
                                    for(int i = 0; i < List.size(); i++)
                                        if(tv.tientongcong >= List.get(i).tientongcong)
                                        {
                                            List.add(i, tv);
                                            chen = true;
                                            break;
                                        }
                                if(chen == false)
                                    List.add(tv);
                                }
                                exit2 = true;
                            }
                            if(loainghengiep == 2){
                                System.out.print("Nhap thong tin cho Linh bao an: ");
                                tv = new LinhBaoAn();
                                tv.Nhap();
                                tv.TinhDiemCH();
                                tv.TinhCuBet();
                                tv.TinhTienThuong();
                                if(List.size() < 1)
                                    List.add(tv);
                                else{
                                    for(int i = 0; i < List.size(); i++)
                                        if(tv.tientongcong >= List.get(i).tientongcong)
                                        {
                                            List.add(i, tv);
                                            chen = true;
                                            break;
                                        }
                                if(chen == false)
                                    List.add(tv);
                                }
                                exit2 = true;
                            }
                            if(loainghengiep != 1 && loainghengiep != 2)
                                System.out.print("Khong hop le, hay nhap lai! ");
                        }while(exit2 == false);
                        break;
                case 0: exit = true;
                        break;
                default:
                        System.out.print("Khong hop le, hay nhap lai! ");
        }
        }while(exit == false);
        PrintWriter out = new PrintWriter(new BufferedWriter( new FileWriter("dsthanhvien.txt", true)));
        System.out.print("-----------------DANH SACH THANH VIEN GIA TOC--------\r\n");
        out.print("-----------------DANH SACH THANH VIEN GIA TOC--------\r\n");
        for(int i = 0; i < List.size(); i++)
        {
            System.out.print("STT: " + (i + 1));
            List.get(i).Xuat();
            out.print("STT: " + (i + 1));
            out.close();
            List.get(i).Write();
        }
    }
        
}
