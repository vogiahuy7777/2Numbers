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
public interface IReceiver {

    /*
     * Để thực hiện việc in từng bước cộng 2 chuỗi số
     * thì lớp nào implements interface này thì phải hiện thực
     * hàm send của IReceiver
     * <br/>
     *
     * @since 2018
     */

    /**
     *
     * @param msg
     */
    

    void send(String msg);

}