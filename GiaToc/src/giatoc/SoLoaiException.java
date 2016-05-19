/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giatoc;

/**
 *
 * @author Reus
 */
public class SoLoaiException extends Exception{
    public SoLoaiException(String msg){
        super(msg);
    }
    public SoLoaiException(){
        super("So khong hop le!");
    }
}
