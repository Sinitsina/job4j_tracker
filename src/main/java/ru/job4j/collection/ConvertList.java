package ru.job4j.collection;
import java.util.*;

public class ConvertList {
    public static List<Integer> convert(List<int[]> list) {
        List<Integer> rsl = new ArrayList<>();
        for (int[] rows : list) {
            for (int num : rows) {
                rsl.add(num);
            }
        }
        return rsl;
    }
}
