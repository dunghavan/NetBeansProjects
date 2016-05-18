/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_arraylist;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Reus
 */
class TestException extends Exception{
    public TestException(String msg){
        super(msg);
    }
}
public class run {


    public static void main(String[] args) throws TestException{
        // TODO code application logic here
        ArrayList <Integer> arr = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        int x = 0;
        for(int i = 0; i < 10; i ++)
        {
            System.out.print("Nhap gia tri: ");
            try{
                x = Integer.parseInt(scan.nextLine());
            if(x < 0)
                    throw new TestException("So am.");
            }
            catch(TestException e) {
                System.out.println(e.getMessage());
            }
            boolean chen = false;
            if(arr.size() < 1)
                arr.add(x);
            else{
                for(int j = 0; j < arr.size(); j++)
                {
                    if(x >= arr.get(j))
                    {
                        arr.add(j, x);
                        chen = true;
                        break;
                    }
                }
                if(chen == false)
                {
                    arr.add(x);
                }
            }
        }
        System.out.print("\n");
        System.out.print(arr);
    }
}
    
