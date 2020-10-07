package com.kodilla.testing.calculator;

public class Calculator {
    private int a;
    private int b;
    private int result;

    public Calculator(int a, int b){
        this.a=a;
        this.b=b;
    }
    public void add(){
        this.result=a+b;
    }
    public void substract(){
        this.result=a-b;
    }
    public int getResult(){
        return result;
    }
}
