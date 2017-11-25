package com.kodilla.rps;


import java.util.Arrays;
import java.util.Random;

public class Rps {

    private int numberOfRounds;
    private boolean end = false;
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
        while(!end){
            startMenu();
            Game();
            endMenu();
           }
           Input.sc.close();
      }

    private void startMenu(){
        System.out.println("Rock-Paper-Scissors");
        System.out.println("Your name:");
        player = new Player(Input.text(),0);
        System.out.println("Key 1 - \"Classic Game\"");
        System.out.println("Key 2 - \"Spock Game\"");

        if( Input.sign(new char[]{'1','2'}) == '1'){
            regex = Arrays.copyOf(new char[] {'1', '2','3','q','r'},5);
            classicGame = true;
        }
        else{
            regex = Arrays.copyOf(new char[] {'1', '2','3','4','5','q','r'},7);
            classicGame = false;
        }
        System.out.println("Number of rounds(1-9):");
        numberOfRounds = Character.getNumericValue(Input.sign(new char[]{'1', '2','3','4','5','6','7','8','9'}));
        computer = new Player("Computer",0);
    }

    private void Game() {
        do {
            System.out.println("Key 1 - Move \"Rock\"");
            System.out.println("Key 2 - Move \"Paper\"");
            System.out.println("Key 3 - Move \"Scissor\"");
            if(!classicGame){
                System.out.println("Key 4 - Move \"Spock\"");
                System.out.println("Key 5 - Move \"Lizard\"");
            }
            System.out.println("Key q - quit game");
            System.out.println("Key r - restart game");

            switch ( Input.sign(regex)) {

                case '1':
                    player.setMove(Move.ROCK);
                    break;
                case '2':
                    player.setMove(Move.PAPER);
                    break;
                case '3':
                    player.setMove(Move.SCISSOR);
                    break;
                case '4':
                    player.setMove(Move.SPOCK);
                     break;
                case '5':
                    player.setMove(Move.LIZARD);
                    break;
                case 'q':
                    System.out.println("Are you sure you want to quit the game? (y/n)");
                    if (Input.sign(new char[]{'y','n'}) == 'y') {
                        end = true;
                        run();
                    }
                    break;
                case 'r':
                    System.out.println("Are you sure you want to restart the game? (y/n)");
                    if (Input.sign(new char[]{'y','n'}) == 'y') {
                        run();
                    }
                    break;
            }

            battle();
            //System.out.println("Rounds: " + numberOfRounds + " Player Points: " + player.getNumberOfPoints() + " Computer Points: " + computer.getNumberOfPoints());
        }
        while (!(player.getNumberOfPoints() >= numberOfRounds || computer.getNumberOfPoints() >= numberOfRounds));


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
        if(player1 == Move.PAPER){
            if(player2 == Move.ROCK || player2 == Move.SPOCK){
                return Score.WON;
            }
        }
        else if(player1 == Move.SCISSOR){
             if( player2 == Move.PAPER || player2 == Move.LIZARD){
                 return Score.WON;
             }
        }
        else if(player1 == Move.ROCK){
            if(player2 == Move.SCISSOR || player2 == Move.LIZARD ){
                return Score.WON;
            }
        } else if(player1 == Move.SPOCK) {
            if (player2 == Move.SCISSOR || player2 == Move.ROCK) {
                return Score.WON;
            }
        } else if(player1 == Move.LIZARD) {
            if (player2 == Move.PAPER || player2 == Move.SPOCK) {
                return Score.WON;
            }
        }

        return Score.LOST;
    }
    private void endMenu() {

        if(player.getNumberOfPoints() > computer.getNumberOfPoints()){
            System.out.println(">>>" + player.getName().toUpperCase() + " won the game<<<");
            hallOfFame.reloadHoF(player);
        }
        else{
            System.out.println(">>>" + computer.getName().toUpperCase() + " won the game<<<");
            hallOfFame.reloadHoF(computer);
        }
        System.out.println();
        do {
            System.out.println("Key q - quit game");
            System.out.println("Key r - restart game");
            System.out.println("Key h - Hall of Fame");

            switch (Input.sign(new char[]{'q','r','h'})){

                case 'q':
                    System.out.println("Are you sure you want to quit the game? (y/n)");
                    if (Input.sign(new char[]{'y','n'}) == 'y') {
                        end = true;
                        run();
                    }
                    break;
                case 'r':
                    System.out.println("Are you sure you want to restart the game? (y/n)");
                    if (Input.sign(new char[]{'y','n'}) == 'y') {
                        run();
                    }
                    break;
                case'h':
                    hallOfFame.show();
                    break;
            }

        }while(!end);
    }
}
