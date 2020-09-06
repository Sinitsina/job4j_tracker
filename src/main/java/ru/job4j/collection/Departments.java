package ru.job4j.collection;

import java.util.*;

public class Departments {
    public static List<String> fillGaps(List<String> deps) {
        HashSet<String> tmp = new HashSet<>();
        for (String value : deps) {
            String start = "";
            for (String el : value.split("/")) {
                if (value.indexOf(el) == 0) {
                    tmp.add(el);
                    start = el;
                    continue;
                }
                tmp.add(start + "/" + el);
                start = start + "/" + el;
            }
        }
        List<String> rsl = new ArrayList<>(tmp);
        Collections.sort(rsl);
        return rsl;

    }

    public static void sortAsc(List<String> orgs) {
        orgs.sort(Comparator.naturalOrder());
    }

    public static void sortDesc(List<String> orgs) {
        Collections.sort(orgs, new DepDescComp());
    }
}
