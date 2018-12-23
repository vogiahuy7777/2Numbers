/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testcase;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gia Huy
 */
import mybignumber.Exception;
import mybignumber.IReceiver;
import mybignumber.MyBigNumber;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Admin
 */
import org.junit.Test;
import static org.junit.Assert.*;


public class MyBigNumberTest implements IReceiver {

    public MyBigNumberTest() {
    }

    /**
     * Test of sum method, of class MyBigNumber.
     */
    @Test
    public void testSum1() {
        try {
            System.out.printf("sum :");
            String str1 = "10";
            String str2 = "10";
            String expResult = "20";
            MyBigNumberTest test = new MyBigNumberTest();
            MyBigNumber mybignumber = new MyBigNumber(test);
            String result = mybignumber.sum(str1, str2);
            assertEquals(expResult, result);
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
    }

    @Test
    public void testSum2() {
        try {
            System.out.printf("sum :");
            String str1 = "99";
            String str2 = "99";
            String expResult = "198";
            MyBigNumberTest test = new MyBigNumberTest();
            MyBigNumber mybignumber = new MyBigNumber(test);
            String result = mybignumber.sum(str1, str2);
            assertEquals(expResult, result);
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
    }

    @Test
    public void testSum3() {
        try {
            System.out.printf("sum :");
            String str1 = "999";
            String str2 = "99";
            String expResult = "1098";
            MyBigNumberTest test = new MyBigNumberTest();
            MyBigNumber mybignumber = new MyBigNumber(test);
            String result = mybignumber.sum(str1, str2);
            assertEquals(expResult, result);
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
    }

    @Test
    public void testSum4() {
        try {
            System.out.printf("sum :");
            String str1 = "99";
            String str2 = "999";
            String expResult = "1098";
            MyBigNumberTest test = new MyBigNumberTest();
            MyBigNumber mybignumber = new MyBigNumber(test);
            String result = mybignumber.sum(str1, str2);
            assertEquals(expResult, result);
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
    }

    @Test
    public void testSum5() {
        try {
            System.out.printf("sum :");
            String str1 = "21";
            String str2 = "10)";
            String expResult = "31";
            MyBigNumberTest test = new MyBigNumberTest();
            MyBigNumber mybignumber = new MyBigNumber(test);
            String result = mybignumber.sum(str1, str2);
            assertEquals(expResult, result);
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
    }

    @Override
    public void send(String msg) {
        System.out.println(msg + "\n");
    }

}