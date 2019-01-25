package com.example.javajokes;

import java.util.List;
import java.util.Random;

import static java.util.Arrays.asList;

public class Joker {

    List<String> jokesList =  asList("joke_1", "joke_2", "joke_3","joke_4","joke_5");

    public  String getJoke() {
        int randomInt= new Random().nextInt(4);
        return jokesList.get(randomInt);
    }


}
