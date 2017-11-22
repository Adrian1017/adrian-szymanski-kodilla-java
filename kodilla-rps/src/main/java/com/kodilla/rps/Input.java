package com.kodilla.rps;

import java.util.Scanner;

public final class Input {

    static public String text() {
        Scanner sc = new Scanner(System.in);
        boolean next = false;
        String text = "";
        do {
            if(sc.hasNext()) {
                text = sc.nextLine();
                if(  text.matches("\\A\\D*\\Z") == true ) {
                    next = false;}
                else {
                    System.out.println("Only letters are allowed!");}
            }
        }
        while(next);
        // sc.close();
        return text;
    }
    static public int  number() {
        Scanner sc = new Scanner(System.in);
        boolean next = true;
        int number = 0;
        do {
            if(sc.hasNextInt()) {
                number = sc.nextInt();
                next = false;}
            else
            {
                System.out.println("Only numbers are allowed!");
                sc.nextLine();}
        }
        while(next);
        //sc.close();
        return number;
    }

    static public char xn123() {
        Scanner sc = new Scanner(System.in);
        boolean next = false;
        String text = "";
        char sign = 0;
        do {
            if(sc.hasNext()) {
                text = sc.nextLine();
                sign = text.charAt(0);
                if(  sign !='n' || sign !='x' || sign !='1' || sign !='2' || sign != '3' ) {
                    next = false;}
                else {
                    System.out.println("Only: '1', '2', '3', 'x', 'n' are allowed!");}
            }
        }
        while(next);
        // sc.close();
        return sign;
    }
}
