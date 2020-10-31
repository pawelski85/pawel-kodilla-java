package com.kodilla.stream.beautifier;

public class StreamMain {
    public static void main(String[] args) {

        PoemBeautifier poemBeautifier=new PoemBeautifier();

        poemBeautifier.beautify("abc",(tekst)-> System.out.println(tekst.toUpperCase()));
        poemBeautifier.beautify("ABC",(tekst)-> System.out.println(tekst.toLowerCase()));
        poemBeautifier.beautify("Pawel",(tekst)-> System.out.println(tekst+ "Tomczyk"));
        poemBeautifier.beautify("Harry",(tekst)-> System.out.println(tekst+"Potter"));
        poemBeautifier.beautify("abc",(String tekst)-> System.out.println("123"+tekst));
        poemBeautifier.beautify("jakis", new PoemDecorator() {
            @Override
            public void decorate(String tekst) {
                System.out.println(tekst+" upiekszacz");
            }
        });

    }
}
