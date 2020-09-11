package ru.job4j.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ProfileTest {
    @Test
    public void whenStudentsSortedInClassA() {
        List<Profile> profiles = Arrays.asList(
                new Profile(new Address("Moscow", "Svoboda", 50, 10)),
                new Profile(new Address("Samara", "Nevsky prospect", 2, 108)),
                new Profile(new Address("Chelyabinsk", "Lenina", 125, 1)));
        List<Address> result = Profile.collect(profiles);
        List<Address> expected = Arrays.asList(
                new Address("Moscow", "Svoboda", 50, 10),
                new Address("Samara", "Nevsky prospect", 2, 108),
                new Address("Chelyabinsk", "Lenina", 125, 1));
        assertThat(result, is(expected));
    }
}