package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
public class TestingMain {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
         int a = 3;
         int b = 3;

        System.out.println("Test 1:");
        if(calculator.add(a,b) == a+b){
            System.out.println("Test OK!");
        }
        else{
            System.out.println("Error!");
        }
        System.out.println("Test 2:");
        if(calculator.subtract(a,b) == a-b){
            System.out.println("Test OK!");
        }
        else{
            System.out.println("Error!");
        }

    }
}
