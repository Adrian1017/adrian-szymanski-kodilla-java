package com.kodilla.rps;

import java.util.Scanner;

public final class Input {

    public static Scanner sc = new Scanner(System.in);

    public static char getChar(char [] regex) {

        String line  = "";

        while (sc.hasNextLine())
        {
            line = sc.nextLine();
            if(!line.equals(""))
            {
                if(line.length() == 1 && checkRegex( line.charAt(0), regex)){
                    break;
                }
            }
            System.out.println("Try again!");
        }
        return line.toLowerCase().charAt(0);
    }


    private static boolean checkRegex(char sign, char [] regex) {

        for (int i = 0; i < regex.length; i++) {
            if (sign == regex[i]) {
                return true;
            }
        }

        return false;
    }


    public static String getText() {

        String line  = "";

        while (sc.hasNextLine())
        {
            line = sc.nextLine();
            if(!line.equals("")&& line.matches("\\A\\D*\\Z") == true )
            {
                break;
            }
            System.out.println("Only letters are allowed.Try again!");
        }
        return line;
    }



}
