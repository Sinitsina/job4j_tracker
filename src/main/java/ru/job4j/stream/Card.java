package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Card {
    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public static void main(String[] args) {
        Stream.of(Suit.values()).forEach(e ->
                Stream.of(Value.values()).forEach(n -> System.out.println(e + " + " + n))
        );
    }

}