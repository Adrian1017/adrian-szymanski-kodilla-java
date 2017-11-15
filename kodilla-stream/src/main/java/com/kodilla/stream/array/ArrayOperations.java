package com.kodilla.stream.array;

import java.util.stream.IntStream;

public interface ArrayOperations {
     public static double getAverage(int [] numbers){
         IntStream.range(0, numbers.length)
                 .map(i -> numbers[i])
                 .forEach( n -> System.out.print(n +" "));

    return IntStream.range(0,numbers.length)
            .map(n -> numbers[n])
            .average().getAsDouble();
     }
}
