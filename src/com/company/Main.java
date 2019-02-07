package com.company;

import jdk.swing.interop.SwingInterOpUtils;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    /**
     *
     *     7. [5] Konwersje liczb miedzy systemami liczbowymi Bin2Dec  i odwrotnie, Hex2Dec i odwrotnie.
     *     Program udostępnia tekstowe menu pozwalające wybrać rodzaj operacji.
     *     Należy zadbać o odpowiednie formatowanie wyświetlanych informacji.
     *      a. Dodatkową funkcjonalnością jest możliwość wygenerowania liczby zapisanej dziesiętnie w dowolnym systemie liczbowym.
     *      Użytkownik w takiej sytuacji jako parametr, oprócz liczby, podaje cyfrę (liczbę) będącą podstawą systemu (dla Hex podstawa = 16, dla Bin = 2)
     */

    public static void main(String[] args) {


        Scanner scn = new Scanner(System.in);
        char[] alphabet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        //for other op-s
        String hexValue = "";
        int binValue = 0;
        int decValue = 0;
        int decValueInt = 0;
        String value = "";
        //for DEC2ANY
        int decVal = 0;
        int operation = -1;
        int numSys = 0;
        String result = "";
        boolean isNegative = false;

        //ENTERING NUMBER
        System.out.println("ENTER YOUR NUMBER TO BE CONVERTED: ");
        value = scn.nextLine();

        //START
        System.out.println("PLEASE CHOOSE YOUR OPERATION");
        System.out.println("0. DEC2BIN");
        System.out.println("1. BIN2DEC");
        System.out.println("2. HEX2DEC");
        System.out.println("3. DEC2HEX");
        System.out.println("4. DEC2ANY");
        operation = scn.nextInt();

        //OPERATIONS MUST BE ENTERED CORRECTLY
        while (operation < 0 || operation > 4){
            System.out.println("PLEASE CHOOSE A CORRECT OPERATION FROM 0 TO 4");
            operation = scn.nextInt();
        }

        if (operation == 4){
            System.out.println("PLEASE ENTER A VALUE OF NUMERIC SYSTEM YOU WANT YOUR NUMBER BE CONVERTED TO");
            numSys = scn.nextInt();
        }



        switch (operation)
        {
            //DEC2BIN
            case 0:
                String dec2bin = Integer.toBinaryString(Integer.parseInt(value));
                System.out.println(dec2bin);
                break;

            //BIN2DEC
            case 1:
                int bin2dec = Integer.parseInt(Integer.toString(Integer.parseInt(value)), 2);
                System.out.println(bin2dec);
                break;
            //HEX2DEC
            case 2:
                int hex2dec = Integer.parseInt(value, 16);
                System.out.println(hex2dec);
                break;
            //DEC2HEX
            case 3:
                String dec2hex = Integer.toHexString(Integer.parseInt(value));
                System.out.println(dec2hex.toUpperCase());
                break;

            //DEC2ANY
            case 4:
                decVal = Integer.parseInt(value);
                if (decVal < 0){
                    decVal = Math.abs(decVal);
                    isNegative = true;
                }

                while (decVal > numSys){
                    if (decVal < numSys)
                        System.out.println(decVal+result);
                    else {
                        result = alphabet[decVal % numSys] + result;
                        decVal = (decVal - decVal % numSys) / numSys;
                        }
                }
                if (isNegative == true){
                    System.out.println("-"+Integer.toString(decVal)+result);
                }
                else
                    System.out.println(Integer.toString(decVal)+result);
            default:
                break;

        }

    }
}
