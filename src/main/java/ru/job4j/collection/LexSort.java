package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] left1 = left.split(". ");
        String numLeft = left1[0];

        String[] right1 = right.split(". ");
        String numRight = right1[0];

        int s = Integer.parseInt(numLeft);
        int s2 = Integer.parseInt(numRight);

        return s-s2;
    }
}
