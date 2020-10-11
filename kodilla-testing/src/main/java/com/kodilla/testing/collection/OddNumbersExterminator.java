package com.kodilla.testing.collection;

import java.util.LinkedList;
import java.util.List;

public class OddNumbersExterminator {

    private List<Integer> numbers=new LinkedList<>();
    private List<Integer> evenListNumbers=new LinkedList<>();

    public List<Integer> exterminate(List<Integer> numbers){
        for (Integer evenNumbers:numbers ) {
            if(evenNumbers%2==0){
                evenListNumbers.add(evenNumbers);
            }
        }
        return evenListNumbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
    public List<Integer> getEvenListNumbers(){ return evenListNumbers; }
}
