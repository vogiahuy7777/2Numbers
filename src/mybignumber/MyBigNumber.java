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

    private  IReceiver ireceiver;

    public MyBigNumber(final IReceiver ireceiver) {
        this.ireceiver = ireceiver;
    }

 
    @SuppressWarnings("empty-statement")
    public String sum(final String s1, final String s2) {
        int position;
        int l1 = s1.length();
        int l2 = s2.length();
        int max =  (l1 > l2) ? l1 : l2; 
        String num1 = s1;
        String num2 = s2;
        String step = ""; // cac buoc thuc hien
        String process = ""; // qua trinh thuc hien
        String sum = "";  //tao ra biến lưu kết quả
        Pattern pattern = Pattern.compile("\\D"); // Chuỗi đại diện cho kí tự số từ [0-9]
        final Matcher isError1 = pattern.matcher(num1); // biến để lưu dữ kết quả xét chuỗi s1 
        final Matcher isError2 = pattern.matcher(num2);;  // biến để lưu dữ kết quả xét chuỗi s2
        int remember = 0; //tạo ra biến lưu số để nhớ nếu kết quả cộng lớn hơn 10
        int saveResult = 0; // biến dùng để lưu kết qua phép cộng của từng kì tụ trong chuỗi

        // đưa ra lỗi nếu có khi dữ liệu được nhập vào
        //kiểm tra người dùng có nhập đủ input chưa
        char char1 = '0';
        char char2 = '0';

        
        // trong se duoc gan bang 0
	if (num1.isEmpty() && !num2.isEmpty()) {			
            return num2;
	}
	if (!num1.isEmpty() && num2.isEmpty()) {
            return num1;
	}
	if (num1.isEmpty() && num2.isEmpty()) {			
            return "0";
	}
        
        // null se gan thanh 0
        if ((s1 == null) || (s1.trim().isEmpty())) {
            num1 = "0";
        }

        if ((s2 == null) || (s2.trim().isEmpty())) {
            num2 = "0";
        }

        // Dùng để kiểm tra nếu người dùng nhập vào là số âm
        if (num1.charAt(0) == '-') {
            position = 1;
            this.ireceiver.send("Error with input negative number: " + num1);
        }

        if (num2.charAt(0) == '-') {
            position = 1;
            ireceiver.send("Error with input negative number: " + num2);
        }

        // Dùng để kiểm tra nếu người dùng nhập vào là ký tự đặc biệt
        Pattern pattern1 = Pattern.compile("[!@#$%&*()_+=|<>?{}\\\\[\\\\]~-]");
        Matcher matcher1 = pattern1.matcher(s1);
        Pattern pattern2 = Pattern.compile("[!@#$%&*()_+=|<>?{}\\\\[\\\\]~-]");
        Matcher matcher2 = pattern1.matcher(s2);

               for (int i = 0; i < l1; i++) {
            if (Character.isLetter(s1.charAt(i))) {
                throw new NumberFormatException("Position " + (i + 1) + " in String " + s1
                        + " not a number");
            }
        }

        for (int i = 0; i < l2; i++) {
            if (Character.isLetter(s2.charAt(i))) {
                throw new NumberFormatException("Position" + (i + 1) + " in String " + s2
                        + " not a number");
            }
        }

        if (matcher1.find()) {
            throw new NumberFormatException("Position " + (matcher1.start() + 1) + " in String " + s1
                    + " not a number");
        }

        if (matcher2.find()) {
            throw new NumberFormatException("Position " + (matcher2.start() + 1) + " in String " + s2
                    + " not a number");
        }
        int i = 0; 
        for (i = 1; i <= max; i++) { 
            char1 = ((l1 - i) >= 0) ? num1.charAt(l1 - i) : '0'; // nếu chuỗi số 1 không còn ta sẽ ghi 0
            char2 = ((l2 - i) >= 0) ? num2.charAt(l2 - i) : '0'; // nếu chuỗi số 2 không còn ta sẽ ghi 0

            saveResult = (char1 - '0') + (char2 - '0') + remember;
            sum = (saveResult % 10) + sum;  // ghi kết quả cộng được vào biến sum
            remember = saveResult / 10; //lưu vào remember là 1 nếu kết quả cộng được lớn hơn 10
            
              
            if (remember == 1) {
                if (num2.length() - i >= 0) {
                    process = "step" + i   + "\n get " + char1 +  "\n add " + char2 +  "\n add " 
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
            sum = (remember) + sum;
            step = step + "step " + i + ", get " + remember + " write trước kết quả\n";
        }
        step = step + "\n The Answer is : " + sum;

        this.ireceiver.send(step);// gửi các bước đến ireceiver để in ra màn hình

        // trả về kết quả của phép cộng
        
        return sum;
    }
}
