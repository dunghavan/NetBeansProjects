
package test_arraylist;

import java.util.ArrayList;
import java.util.Scanner;


public class Test_ArrayList {


    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList <Integer> arr = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        for(int i = 0; i < 10; i ++)
        {
            System.out.print("Nhap gia tri: ");
            int x = Integer.parseInt(scan.nextLine());
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
