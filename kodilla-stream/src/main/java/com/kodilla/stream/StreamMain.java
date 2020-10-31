package com.kodilla.stream;

import com.kodilla.stream.lambda.ExecuteSaySomething;
import com.kodilla.stream.lambda.Processor;
import com.kodilla.stream.lambda.SaySomething;

public class StreamMain {
    public static void main(String[] args) {

        ExecuteSaySomething executeSaySomething=new ExecuteSaySomething();
        executeSaySomething.process();
    }
}


