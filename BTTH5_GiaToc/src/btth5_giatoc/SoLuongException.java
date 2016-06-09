/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btth5_giatoc;

import javax.swing.JOptionPane;

/**
 *
 * @author Reus
 */
public class SoLuongException extends Exception{
    public SoLuongException(String msg){
        JOptionPane.showMessageDialog(null, msg, "Lỗi!!!", 2);
    }
    public SoLuongException(){
        //super();
    }
}
