package com.kodilla.testing.collection;

import java.util.List;
import java.util.stream.Collectors;

public class OddNumberExterminator {

    public List<Integer> exterminate(List<Integer> numbers){
        if(numbers.isEmpty()){
            return null;
        }
        for( int i = 0; i < numbers.size();i++){
            if(numbers.get(i) % 2 !=0){
                numbers.remove(i);
            }
        }
        return numbers;
    }
    public List<Integer> exterminateJ8(List<Integer> numbers){
        if(numbers.isEmpty()){
            return null;
        }
        return numbers.stream().filter( i -> i % 2 ==0).collect(Collectors.toList());

    }
}
