/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btth5_giatoc;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Reus
 */
public class DocFile {

    /**
     * @param pnt1
     * @throws java.io.FileNotFoundException
     */
    public DocFile(String fileName, int cost1, int cost2, int cost3, int cost4,
            int pnt1, int pnt2, int pnt3, int pnt4) throws FileNotFoundException, IOException{
        // TODO code application logic here
        //Vi du doc du lieu tu file
        class Struct {
        private String ten = "";
        private String gia = "";
        private String DCH = "";
    }
        ArrayList<Struct> arr = new ArrayList<Struct>();
        FileReader in = new FileReader("BangThuoc.txt");
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
            if(ob.ten.equalsIgnoreCase("LinhChi")){
                cost1 = Integer.parseInt(ob.gia);
                pnt1 = Integer.parseInt(ob.DCH.trim());
            }
            if(ob.ten.equalsIgnoreCase("HaThuO")){
                cost2 = Integer.parseInt(ob.gia);
                pnt2 = Integer.parseInt(ob.DCH.trim());
            }
            if(ob.ten.equalsIgnoreCase("NhanSam")){
                cost3 = Integer.parseInt(ob.gia);
                pnt3 = Integer.parseInt(ob.DCH.trim());
            }
            if(ob.ten.equalsIgnoreCase("ThatTamLien")){
                cost4 = Integer.parseInt(ob.gia);
                pnt4 = Integer.parseInt(ob.DCH.trim());
            }
        }
        //in.close();
    }
}
