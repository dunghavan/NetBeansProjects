/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testfilereader_filewriter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
        FileReader in = new FileReader("file1.txt");
        char[] a = new char[300];
        in.read(a);
        for(char c : a)
            System.out.print(c);
        in.close();
        //Ghi du lieu xuong file:
        FileWriter out = new FileWriter("File2.txt");
        System.out.println("\nNhap thong tin muon ghi xuong file: ");
        Scanner scan  = new Scanner(System.in);
        String thongtin = scan.nextLine();
        out.write(thongtin);
        System.out.println("\nDa ghi thong tin xuong file.");
        out.close();
    }
}
