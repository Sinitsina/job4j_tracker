package ru.job4j.exams;

import java.util.HashMap;
import java.util.Map;

public class FreezeStr {

    public static boolean eq(String left, String right) {
        Map<Integer, Character> map = new HashMap<>();

        for (int i = 0; i < left.length(); i++) {
            map.put(i, left.charAt(i));
        }

        for (int i = 0; i < right.length(); i++) {
            if (map.containsValue(right.charAt(i))) {
                map.values().remove(right.charAt(i));
            }
        }

        return map.isEmpty();
    }
}
