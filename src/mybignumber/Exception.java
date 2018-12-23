/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybignumber;

/**
 *
 * @author Gia Huy
 */
public class Exception extends NumberFormatException {
      private int pos;
    
    public Exception(int num) {
        pos = num;
    }
    
    @Override
    public String toString() {
        return pos + "";
    }
    
}