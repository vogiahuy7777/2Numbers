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
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MyBigNumber {

    private final IReceiver ireceiver;

    public MyBigNumber(final IReceiver ireceiver) {
        this.ireceiver = ireceiver;
    }

 
    @SuppressWarnings("empty-statement")
    public String sum(final String str1, final String str2) {
        int position;
        int l1 = str1.length();
        int l2 = str2.length();
        int max =  (l1 > l2) ? l1 : l2; 
        String num1 = str1;
        String num2 = str2;
        String step = "";
        String process = "";
        String sum = "";
        Pattern pattern = Pattern.compile("\\D"); 
        final Matcher isError1 = pattern.matcher(num1);
        final Matcher isError2 = pattern.matcher(num2);;
        int remember = 0;
        int saveResult = 0; 

        char char1 = '0';
        char char2 = '0';

        if (num1.isEmpty()) {
            position = 1;
            this.ireceiver.send("Enter the first one : ");
            throw new Exception(position);
        }

        if (num2.isEmpty()) {
            position = 1;
            this.ireceiver.send("Enter the second one: ");
            throw new Exception(position);
        }


        if (num1.charAt(0) == '-') {
            position = 1;
            this.ireceiver.send("Error with input negative number: " + num1);
            throw new Exception(position);
        }

        if (num2.charAt(0) == '-') {
            position = 1;
            ireceiver.send("Error with input negative number: " + num2);
            throw new Exception(position);
        }

  
        if (isError1.find()) {
            position = isError1.start() + 1;
            this.ireceiver.send("position " + position + " in array " + num1 + " is not nummber");
            throw new Exception(position);
        }

        if (isError2.find()) {
            position = isError2.start() + 1;
            this.ireceiver.send("position " + position + " in array " + num2 + " is not number");
            throw new Exception(position);

        }
        int i = 0; 
        for (i = 1; i <= max; i++) { 
            char1 = ((l1 - i) >= 0) ? num1.charAt(l1 - i) : '0'; 
            char2 = ((l2 - i) >= 0) ? num2.charAt(l2 - i) : '0'; 

            saveResult = (char1 - '0') + (char2 - '0') + remember;
            sum = Integer.toString(saveResult % 10) + sum; 
            remember = saveResult / 10;

            if (remember == 1) {
                if (num2.length() - i >= 0) {
                    process = "step" + i + ":" + "1" + "\n get " + char1 + "2" + "\n add " + char2 + "3" + "\n add " 
                        + remember + " \n nhave " + saveResult + "\n write " + saveResult % 10 + ", \n remember" + remember + "\n";
                } else {
                    process = "\nstep " + i + ", \nget " + char1 + " \nadd " + remember 
                        + " \nhave " + saveResult + "\nwrite " + saveResult % 10 + "\nremember " + remember + "\n";
                }
            } else {
                if (num2.length() - i >= 0) {
                    process = "\nstep " + i + "\nget " + char1 + " \nadd " 
                        + char2 + " \nhave " + saveResult + "\nwrite " + saveResult % 10 + "\n";
                } else {
                    process = "\nstep " + i + ", \nget" + char1 + " add 0" 
                        + " \nhave " + saveResult + "\nwrite " + saveResult % 10 + "\n";
                }
            }

            step = step + process;
        }

        if (remember == 1) {
            sum = Integer.toString(remember) + sum;
            step = step + "step " + i + ", get " + remember + " write trước kết quả\n";
        }
        step = step + "\n The Answer is : " + sum;

        this.ireceiver.send(step);
        
        return sum;
    }
}
