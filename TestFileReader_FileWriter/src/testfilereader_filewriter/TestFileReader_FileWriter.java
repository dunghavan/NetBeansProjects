/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testfilereader_filewriter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Reus
 */
public class TestFileReader_FileWriter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException{
        // TODO code application logic here
        //Vi du doc du lieu tu file
//        class TenThuoc {
//        private String ten = "";
//        private String gia = "";
//        private String DCH = "";
//    }
//        ArrayList<TenThuoc> arr = new ArrayList<>();
//        FileReader in = new FileReader("BangThuoc.txt");
//        char[] a = new char[300];
//        in.read(a);
//        TenThuoc object = new TenThuoc();
//        int tab = 0;
//        for(int i = 0; i < a.length; i++){
//            if (tab == 0)
//            {
//                if(String.valueOf(a[i]).equals("\t")){ 
//                    tab = 1; i++;}
//                else
//                    object.ten += String.valueOf(a[i]);
//            }
//            if(tab == 1){
//                if(String.valueOf(a[i]).equals("\t")){ tab = 2; i++;}
//                else
//                    object.gia += String.valueOf(a[i]);
//            }
//            if(tab == 2){
//                if(String.valueOf(a[i]).equals("\n")){
//                    arr.add(object);
//                    object = new TenThuoc();
//                    tab = 0;
//                } else
//                    if(String.valueOf(a[i]) == null){
//                    arr.add(object);
//                    object = new TenThuoc();
//                    } else
//                        object.DCH += String.valueOf(a[i]);
//            }
//        }
//        System.out.println("mang la: \n");
//        for(TenThuoc o : arr)
//            System.out.println(o.ten + " " + o.gia + " " + o.DCH);
//        in.close();
        //Ghi du lieu xuong file:
        String thongtin;
        Scanner scan  = new Scanner(System.in);
        
//        FileWriter out = new FileWriter("file2.txt");
//        System.out.println("\nNhap thong tin muon ghi xuong file: ");
//        thongtin = scan.nextLine();
//        out.write(thongtin);
//        System.out.println("\nDa ghi thong tin xuong file.");
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("file2.txt", true)));
            out.print("the first");
            out.print("The seconds");
            out.close();
        System.out.println("\nDa ghi thong tin xuong file.");
    }
}
