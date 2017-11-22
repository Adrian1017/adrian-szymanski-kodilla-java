package com.kodilla.exception.test;

public class ExceptionHandling {
    public static void main(String[] args) {
        SecondChallenge secondChallenge = new SecondChallenge();

        try{
            String test = secondChallenge.probablyIWillThrowException(2,2);
            System.out.println(test);
        }catch (Exception e){
            System.out.println("Error:" + e);
        }finally {
            System.out.println("I am gonna be here... always!");
        }
    }
}
