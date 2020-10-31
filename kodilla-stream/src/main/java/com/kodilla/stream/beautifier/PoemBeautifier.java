package com.kodilla.stream.beautifier;

import com.sun.scenario.effect.impl.sw.java.JSWBlend_SRC_OUTPeer;

public class PoemBeautifier{


    public void beautify(String tekst,PoemDecorator poemDecorator) {
        poemDecorator.decorate(tekst);
    }
}
