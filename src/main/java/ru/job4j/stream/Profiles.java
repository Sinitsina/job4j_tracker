package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    static List<Address> collect(List<Profile> profiles) {
        List<Address> result = profiles.stream()
                .map(n -> n.getAddress())
                .collect(Collectors.toList());
        return result;
    }
}
