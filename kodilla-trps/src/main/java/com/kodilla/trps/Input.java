package com.kodilla.trps;

import java.io.DataInputStream;
import java.io.PrintStream;
import java.net.Socket;


public class Input {
    private Socket clientSocket = null;
    private DataInputStream ins = null;
    private PrintStream outs = null;

    public Input(Socket clientSocket) {
        this.clientSocket = clientSocket;

    }

    private void printStream( String string){
        try{
            outs = new PrintStream(clientSocket.getOutputStream());
            outs.println(string + "\r"); // for linux server! ( line break types: CR LF (Windows), LF (Unix), CR (Macintosh) )
        }catch (Exception e){
            System.out.println("Error: Input:Printstream :" + e);
        }
    }
    private String inputStream(){
        String line = "";
        try{
            ins = new DataInputStream(clientSocket.getInputStream());
            line = ins.readLine().trim();
            return line;
        }catch (Exception e){
            System.out.println("Error: Input:InputStream :" + e );
        }
            return line;
    }

    public String getText(){
        String line  = "";
        boolean exit = false;
        do{
            line = inputStream();
            if(!line.equals("")&& line.matches("\\A\\D*\\Z") == true )
            {
                exit = true;
            }
            else{
                printStream("Only letters are allowed.Try again!");
            }
        }while (!exit);
        return line;
    }

    public char getChar(char [] regex) {
        String line  = "";
        boolean exit = false;
        do
        {
            line = inputStream();
            if(!line.equals(""))
            {
                if(line.length() == 1 && checkRegex( line.charAt(0), regex)){
                    break;
                }
            }
            printStream("Try again!");
        }while (!exit);

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

}
