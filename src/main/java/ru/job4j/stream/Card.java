package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Stream.*;

public class Card {
    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public Suit getSuit() {
        return suit;
    }

    public static void main(String[] args) {
        /*Stream.of(Suit.values()).forEach(e ->
                Stream.of(Value.values()).forEach(n -> System.out.println(e + " + " + n))
        );*/

        Stream.of(Suit.values()).map(e -> Stream.of(Value.values()).map(n -> e.toString() + n.toString()))
                .collect(Collectors.toList());
    }

}