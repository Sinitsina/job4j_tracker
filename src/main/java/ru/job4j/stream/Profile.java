package ru.job4j.stream;

import java.util.*;
import java.util.stream.Collectors;

public class Profile {
    private Address address;

    public Profile(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    static List<Address> collect(List<Profile> profiles) {
        List<Address> result = profiles.stream()
                .map(n -> n.getAddress())
                .collect(Collectors.toList());
        return result;
    }
}
