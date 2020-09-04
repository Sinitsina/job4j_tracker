package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        for (int i = 0; i < Math.min(left.length(), right.length()); i++) {
            int rsl = Character.compare(left.charAt(i), right.charAt(i));
            if (rsl != 0) {
                return left.charAt(i) - right.charAt(i);
            }
        }
        return left.length() - right.length();
    }
}
