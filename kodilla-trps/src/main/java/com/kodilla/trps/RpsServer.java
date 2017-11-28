package com.kodilla.trps;

import java.io.DataInputStream;
import java.io.PrintStream;
import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;
import java.util.Arrays;
import java.util.Random;


public class RpsServer {


    private static ServerSocket serverSocket = null;
    private static Socket clientSocket = null;

    private static final int maxPlayersCount = 10;
    private static final ClientPlayer[] threads = new ClientPlayer[maxPlayersCount];

    public static void main(String args[]) {

        int portNumber;
        if (args.length < 1) {
           portNumber = 23;
        } else {
            portNumber = Integer.valueOf(args[0]).intValue();
        }

        System.out.println("RPS Server is starting at port:" + portNumber);

        try {
            serverSocket = new ServerSocket(portNumber);
        } catch (IOException e) {
            System.out.println("Error: Server start :" +e);
        }

        while (true) {
            try {
                clientSocket = serverSocket.accept();
                int i;
                    for (i = 0; i < maxPlayersCount; i++) {
                        if (threads[i] == null) {
                            System.out.println("Player[" + i + "]" + " is connected");
                            (threads[i] = new ClientPlayer(clientSocket, threads)).start();
                            break;
                        }
                    }

                if (i == maxPlayersCount) {
                    PrintStream os = new PrintStream(clientSocket.getOutputStream());
                    os.println("Server busy. Try later.");
                    os.close();
                    clientSocket.close();
                }

            } catch (IOException e) {
                System.out.println("Error: Server :" +e);
            }
        }
    }
}

class ClientPlayer extends Thread {

    private DataInputStream ins = null;
    private PrintStream outs = null;
    private Socket clientSocket = null;
    private final ClientPlayer[] threads;

    private int maxPlayersCount;
    private HallOfFame hallOfFame;
    private Input input;

    private int numberOfRounds;
    private boolean gameRunning = true;
    private boolean gameExit = false;
    private boolean classicGame = true;
    private char[] regex;
    private Random random = new Random();
    private Player player;
    private Player computer;


    private enum Score {
        WON,LOST, DRAW
    }



      public ClientPlayer(Socket clientSocket, ClientPlayer[] threads) {

        this.clientSocket = clientSocket;
        this.threads = threads;
        maxPlayersCount = threads.length;
        hallOfFame = new HallOfFame(clientSocket);
        input = new Input(clientSocket);
    }

    public void run() {
        int maxPlayersCount = this.maxPlayersCount;
        ClientPlayer[] threads = this.threads;
        try {
            while (!gameExit) {

                startMenu();
                startGame();
            }
            printStream("Bye!");

                synchronized (this) {
                    for (int i = 0; i < maxPlayersCount; i++) {
                        if (threads[i] == this) {
                            System.out.println("Player[" + i + "]" + " is disconnected");
                            threads[i] = null;
                        }
                    }
                }
                clientSocket.close();
        } catch (IOException e) {
            System.out.println("Error: Client :" + e );
        }
    }

    private void printStream( String string){
        try{
            outs = new PrintStream(clientSocket.getOutputStream());
            outs.println(string + "\r"); // for linux server! ( line break types: CR LF (Windows), LF (Unix), CR (Macintosh) )
        }catch (IOException e){
            System.out.println("Error: Server:PrintStream :" +e );
        }
    }

    private void startMenu() {
            printStream("Rock-Paper-Scissors");
            printStream("Your name:");
            player = new Player(input.getText(), 0);
            printStream("Key 1 - \"Classic game\"");
            printStream("Key 2 - \"Spock game\"");

            if (input.getChar(new char[]{'1', '2'}) == '1') {
                regex = Arrays.copyOf(new char[]{'1', '2', '3', 'q', 'r'}, 5);
                classicGame = true;
            } else {
                regex = Arrays.copyOf(new char[]{'1', '2', '3', '4', '5', 'q', 'r'}, 7);
                classicGame = false;
            }
            printStream("Number of rounds(1-9):");
            numberOfRounds = Character.getNumericValue(input.getChar(new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'}));
            computer = new Player("Computer", 0);
            gameRunning = true;
    }

    private void startGame() {
        while(gameRunning){
            printStream("Key 1 - Move \"Rock\"");
            printStream("Key 2 - Move \"Paper\"");
            printStream("Key 3 - Move \"Scissor\"");
            if(!classicGame){
                printStream("Key 4 - Move \"Spock\"");
                printStream("Key 5 - Move \"Lizard\"");
            }
            printStream("Key q - quit game");
            printStream("Key r - restart game");

            switch ( input.getChar(regex)) {

                case '1':
                    player.setMove(Move.ROCK);
                    battle();
                    break;
                case '2':
                    player.setMove(Move.PAPER);
                    battle();
                    break;
                case '3':
                    player.setMove(Move.SCISSOR);
                    battle();
                    break;
                case '4':
                    player.setMove(Move.SPOCK);
                    battle();
                    break;
                case '5':
                    player.setMove(Move.LIZARD);
                    battle();
                    break;
                case 'q':
                    printStream("Are you sure you want to quit the game? (y/n)");
                    if (input.getChar(new char[]{'y','n'}) == 'y') {
                        gameRunning = false;
                        gameExit = true;
                    }
                    break;
                case 'r':
                    printStream("Are you sure you want to restart the game? (y/n)");
                    if (input.getChar(new char[]{'y','n'}) == 'y') {
                        gameRunning = false;
                    }
                    break;
            }

            if(player.getNumberOfPoints() >= numberOfRounds || computer.getNumberOfPoints() >= numberOfRounds ){
                showWhoWon();
            }
        }
    }

    private void battle(){
        if(classicGame) {
            computer.setMove(Move.values()[random.nextInt(3)]);
        }
        else{
            computer.setMove(Move.values()[random.nextInt(5)]);
        }
        printStream(player.getMove() + " vs. " + computer.getMove());

        if (scoreOfBattle(player.getMove(), computer.getMove())== Score.WON ){
            player.addPoint();
            printStream( ">" + player.getName() + "<" + " won this round!");
        } else if(scoreOfBattle(player.getMove(), computer.getMove())== Score.LOST )
        {
            computer.addPoint();
            printStream(">" + computer.getName() + "<" + " won this round!");
        }
        else{
            printStream("Draw!");
        }
        printStream("\n");

    }
    private Score scoreOfBattle(Move player1, Move player2) {

        if( player1 == player2){
            return Score.DRAW;
        }
        if(player1 == Move.PAPER && (player2 == Move.ROCK || player2 == Move.SPOCK)){
            return Score.WON;
        }
        else if(player1 == Move.SCISSOR && ( player2 == Move.PAPER || player2 == Move.LIZARD)){
            return Score.WON;
        }
        else if(player1 == Move.ROCK &&(player2 == Move.SCISSOR || player2 == Move.LIZARD ) ){
            return Score.WON;
        } else if(player1 == Move.SPOCK && (player2 == Move.SCISSOR || player2 == Move.ROCK)) {
            return Score.WON;

        } else if(player1 == Move.LIZARD && (player2 == Move.PAPER || player2 == Move.SPOCK)) {
            return Score.WON;
        }

        return Score.LOST;
    }
    private void showWhoWon() {

        if(player.getNumberOfPoints() > computer.getNumberOfPoints()){
            printStream(">>>" + player.getName().toUpperCase() + " won the game<<<");
            hallOfFame.reloadHallOfFame(player);
        }
        else{
            printStream(">>>" + computer.getName().toUpperCase() + " won the game<<<");
            hallOfFame.reloadHallOfFame(computer);
        }
        printStream("\n");
        do {
            printStream("Key q - quit game");
            printStream("Key r - restart game");
            printStream("Key h - Hall of Fame");

            switch (input.getChar(new char[]{'q','r','h'})){

                case 'q':
                    printStream("Are you sure you want to quit the game? (y/n)");
                    if (input.getChar(new char[]{'y','n'}) == 'y') {
                        gameRunning = false;
                        gameExit = true;
                    }
                    break;
                case 'r':
                    printStream("Are you sure you want to restart the game? (y/n)");
                    if (input.getChar(new char[]{'y','n'}) == 'y') {
                        gameRunning = false;
                    }
                    break;
                case'h':
                    hallOfFame.show();
                    break;
            }

        }while(gameRunning);
    }
}