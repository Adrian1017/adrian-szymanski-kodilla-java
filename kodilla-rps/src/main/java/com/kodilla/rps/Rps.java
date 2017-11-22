package com.kodilla.rps;


import java.util.Random;

public class Rps {
    private int numberOfWonRounds;
    private boolean end = false;
    private HandScore handScore;
    private Random random = new Random();
    Player player;
    Player computer = new Player("Computer");


    public void run(){
        while(!end){
            startMenu();
            mainGame();
            endGame();
           }
      }

    private void startMenu(){
        System.out.println("Podaj imie gracza");
        player = new Player(Input.text());
        System.out.println("Podaj liczbe rund");
        numberOfWonRounds = Input.number();
        computer = new Player("Computer");
    }
    private void mainGame() {
        do {
            System.out.println("Klawisz 1 - zagranie \"kamień\"");
            System.out.println("Klawisz 2 - zagranie \"papier\"");
            System.out.println("Klawisz 3 - zagranie \"nożyce\"");
            System.out.println("Klawisz x - zakończenie gry");
            System.out.println("Klawisz n - uruchomienie gry od nowa");
            char sign = Input.xn123();
            switch (sign) {

                case '1':
                    player.setHand(Hand.ROCK);
                    break;
                case '2':
                    player.setHand(Hand.PAPER);
                    break;
                case '3':
                    player.setHand(Hand.SCISSOR);
                    break;
                case 'x':
                    System.out.println("Czy na pewno zakończyć grę? (tak/nie)");
                    if (Input.text().toLowerCase().contains("tak")) {
                        end = true;
                        run();
                    }
                    break;

                case 'n':
                    System.out.println("Czy na pewno zakończyć aktualna grę? (tak/nie)");
                    if (Input.text().toLowerCase().contains("tak")) {
                        run();
                    }
                    break;
            }

            computer.setHand(Hand.values()[random.nextInt(3)]);
            System.out.println(player.getHand() + " Vs. " + computer.getHand());
            if (battleWonPlayer1(player.getHand(), computer.getHand())== HandScore.WON ){
                player.addPoint();
                System.out.println("Te runde wygral " + player.getName());
            } else if(battleWonPlayer1(player.getHand(), computer.getHand())== HandScore.LOST )
                {
                computer.addPoint();
                System.out.println("Te runde wygral " + computer.getName());
            }
            else{
                System.out.println("Remis!");
            }
        }
        while (!(player.getNumberOfPoints() >= numberOfWonRounds || computer.getNumberOfPoints() >= numberOfWonRounds));


    }

    private void endGame() {

        if(player.getNumberOfPoints() > computer.getNumberOfPoints()){
            System.out.println("Gre wygral " + player.getName() + "!");
        }
        else{
            System.out.println("Gre wygral " + computer.getName() + "!");
        }
        System.out.println("\n");
        System.out.println("klawisz x - zakończenie gry,");
        System.out.println("klawisz n - uruchomienie gry od nowa");
        if(Input.xn123() == 'x'){
            end = true;
        }
        else{
            run();
        }
    }

    private HandScore battleWonPlayer1(Hand player1, Hand player2) {

        if( player1 == player2){
            return HandScore.DRAW;
        }
        if(player1 == Hand.PAPER){
            if(player2 == Hand.ROCK){
                return HandScore.WON;
            }
        }
        else if(player1 == Hand.SCISSOR){
             if( player2 == Hand.PAPER){
                 return HandScore.WON;
             }
        }
        else if(player1 == Hand.ROCK){
            if(player2 == Hand.SCISSOR){
                return HandScore.WON;
            }
        }
        return HandScore.LOST;
    }
}
