package ru.job4j.stream;
import java.util.*;
import java.util.stream.Collectors;

public class IntegerMatrix {
    Integer[][] matrix = {{1, 2, 3},
            {4, 5, 6}};

    static List<Integer> convert(Integer[][] matrix) {
        return Arrays.stream(matrix).flatMap(Arrays::stream).collect(Collectors.toList());
    }
}
