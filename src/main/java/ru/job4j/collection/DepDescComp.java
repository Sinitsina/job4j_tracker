package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        for (int i = 0; i < Math.min(o1.length(), o2.length()); i++) {
            int rsl = o2.charAt(i) - o1.charAt(i);
            if (rsl != 0) {
                if (i > 2) {
                    rsl = o1.charAt(i) - o2.charAt(i);
                }
                return rsl;
            }
        }
        return o1.length() - o2.length();
    }
}
