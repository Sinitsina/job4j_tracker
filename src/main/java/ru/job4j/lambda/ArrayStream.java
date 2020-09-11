package ru.job4j.lambda;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayStream {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();

        for (int i = -3; i < 10; i++) {
            numbers.add(i);
        }

        List<Integer> positiveNumbers = numbers.stream().filter(
                number -> number > 0
        ).collect(Collectors.toList());
    }
}
