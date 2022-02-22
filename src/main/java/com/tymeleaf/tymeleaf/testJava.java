package com.tymeleaf.tymeleaf;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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


//        for(int i = 0; i < 5; i++){
//            List<String> rList = new ArrayList<>();
//            rList.add("1");
//            rList.add("2");
//            System.out.println("rList = " + rList);
//            rList = null;
//        }


        Integer i = 1000;
        Integer k = 1000;
        if(!(Objects.equals(i, k))){
            System.out.println("다름");
        }else{
            System.out.println("같음");
        }

    }
}
