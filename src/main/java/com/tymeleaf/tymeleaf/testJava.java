package com.tymeleaf.tymeleaf;


import java.util.regex.Pattern;

public class testJava {
    public static boolean checkBirth(String str) {
        return Pattern.matches("^\\d{2}(0[1-9]|1[0-2])(0[1-9]|[1,2][0-9]|[3][0,1])", str);
    }
    public static boolean checkMobile(String str) {
        return Pattern.matches("^01(?:0|1|[6-9])(?:\\d{3}|\\d{4})\\d{4}$", str);
    }

    public static void main(String[] args) {

        String str = "901231";
        boolean result = checkBirth(str);
        System.out.println("result = " + result);

        String str2 = "01758502269";
        boolean result2 = checkMobile(str2);
        System.out.println("result2 = " + result2);


    }
}
