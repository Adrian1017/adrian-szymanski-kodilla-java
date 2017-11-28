package com.kodilla.rps;


import java.util.Arrays;
import java.util.Random;

public class Rps {

    private int numberOfRounds;
    private boolean gameRunning = true;
    private boolean gameExit = false;
    private boolean classicGame = true;
    private char[] regex;
    private Random random = new Random();
    private HallOfFame hallOfFame = new HallOfFame();
    private Player player;
    private Player computer;

    private enum Score {
        WON,LOST, DRAW
    }



    public void run(){
         while(!gameExit){
            startMenu();
            startGame();
           }
        System.out.println("Bye!");
        Input.sc.close();

      }


    private void startMenu(){
        System.out.println("Rock-Paper-Scissors");
        System.out.println("Your name:");
        player = new Player(Input.getText(),0);
        System.out.println("Key 1 - \"Classic game\"");
        System.out.println("Key 2 - \"Spock game\"");

        if( Input.getChar(new char[]{'1','2'}) == '1'){
            regex = Arrays.copyOf(new char[] {'1', '2','3','q','r'},5);
            classicGame = true;
        }
        else{
            regex = Arrays.copyOf(new char[] {'1', '2','3','4','5','q','r'},7);
            classicGame = false;
        }
        System.out.println("Number of rounds(1-9):");
        numberOfRounds = Character.getNumericValue(Input.getChar(new char[]{'1', '2','3','4','5','6','7','8','9'}));
        computer = new Player("Computer",0);
        gameRunning = true;
    }

    private void startGame() {

        while (gameRunning){
            System.out.println("Key 1 - Move \"Rock\"");
            System.out.println("Key 2 - Move \"Paper\"");
            System.out.println("Key 3 - Move \"Scissor\"");
            if(!classicGame){
                System.out.println("Key 4 - Move \"Spock\"");
                System.out.println("Key 5 - Move \"Lizard\"");
            }
            System.out.println("Key q - quit game");
            System.out.println("Key r - restart game");

            switch ( Input.getChar(regex)) {

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
                    System.out.println("Are you sure you want to quit the game? (y/n)");
                    if (Input.getChar(new char[]{'y','n'}) == 'y') {
                        gameRunning = false;
                        gameExit = true;
                    }
                    break;
                case 'r':
                    System.out.println("Are you sure you want to restart the game? (y/n)");
                    if (Input.getChar(new char[]{'y','n'}) == 'y') {
                        gameRunning = false;
                    }
                    break;
            }


            if(player.getNumberOfPoints() >= numberOfRounds || computer.getNumberOfPoints() >= numberOfRounds ){
               showWhoWon();
            }
            //System.out.println("Rounds: " + numberOfRounds + " Player Points: " + player.getNumberOfPoints() + " Computer Points: " + computer.getNumberOfPoints());
        }

}


    private void battle(){
        if(classicGame) {
            computer.setMove(Move.values()[random.nextInt(3)]);
        }
        else{
            computer.setMove(Move.values()[random.nextInt(5)]);
        }
        System.out.println(player.getMove() + " vs. " + computer.getMove());

        if (scoreOfBattle(player.getMove(), computer.getMove())== Score.WON ){
            player.addPoint();
            System.out.println( ">" + player.getName() + "<" + " won this round!");
        } else if(scoreOfBattle(player.getMove(), computer.getMove())== Score.LOST )
        {
            computer.addPoint();
            System.out.println(">" + computer.getName() + "<" + " won this round!");
        }
        else{
            System.out.println("Draw!");
        }
        System.out.println();

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
            System.out.println(">>>" + player.getName().toUpperCase() + " won the game<<<");
            hallOfFame.reloadHallOfFame(player);
        }
        else{
            System.out.println(">>>" + computer.getName().toUpperCase() + " won the game<<<");
            hallOfFame.reloadHallOfFame(computer);
        }
        System.out.println();
        do {
            System.out.println("Key q - quit game");
            System.out.println("Key r - restart game");
            System.out.println("Key h - Hall of Fame");

            switch (Input.getChar(new char[]{'q','r','h'})){

                case 'q':
                    System.out.println("Are you sure you want to quit the game? (y/n)");
                    if (Input.getChar(new char[]{'y','n'}) == 'y') {
                        gameRunning = false;
                        gameExit = true;
                    }
                    break;
                case 'r':
                    System.out.println("Are you sure you want to restart the game? (y/n)");
                    if (Input.getChar(new char[]{'y','n'}) == 'y') {
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
