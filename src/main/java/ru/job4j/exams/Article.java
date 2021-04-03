package ru.job4j.exams;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Article {

    public static boolean generateBy(String origin, String line) {
        Set<String> hashSet = new HashSet<String>(Arrays.asList(origin.toLowerCase()
                .replaceAll("\\p{Punct}", "").split(" ")));
        int size = hashSet.size();

        hashSet.addAll(Arrays.asList(line.toLowerCase()
                .replaceAll("\\p{Punct}", "").split(" ")));

        int newSize = hashSet.size();

        return size == newSize;
    }
}
