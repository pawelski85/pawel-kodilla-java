package com.kodilla.testing;
import com.kodilla.testing.calculator.Calculator;

public class TestingMain {
    public static void main(String[] args) {
       Calculator calculator=new Calculator(2,2);

       calculator.add();
       if(calculator.getResult()==4){
           System.out.println("test OK");
       }
       else{
           System.out.println("Error");
       }

       calculator.substract();
       if(calculator.getResult()==0){
           System.out.println("test OK");
       }
       else{
           System.out.println("Error");
       }
    }
}
