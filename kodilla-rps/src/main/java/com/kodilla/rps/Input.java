package com.kodilla.rps;

import java.util.Scanner;

public final class Input {

   static public Scanner sc = new Scanner(System.in);

    static public char sign(char [] regex) {

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


    static private boolean checkRegex(char sign, char [] regex) {

            for (int i = 0; i < regex.length; i++) {
                if (sign == regex[i]) {
                    return true;
                }
            }

        return false;
    }


    static public String text() {

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
