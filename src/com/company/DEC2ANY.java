package com.company;

public class DEC2ANY {
    public static char[] alphabet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray(); // 0-9 + A-Z = 35

    void String (int decValue, int numericalSys){
        if (decValue >= 0){
            while(decValue > numericalSys){
                String result = "";
                int resultInt = decValue%numericalSys;
                System.out.println(resultInt);
            }
        }
    }
}
