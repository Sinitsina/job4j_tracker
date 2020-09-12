package ru.job4j.stream;

import org.junit.Test;
import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MapStudentsTest {
    @Test
    public void whenStudentsAreDifferent() {
        List<Student> students = Arrays.asList(
                new Student("Ivanov", 60),
                new Student("Petrov", 40),
                new Student("Sidorov", 90),
                new Student("Kozlov", 85));
        Map<String, Student> result = MapStudents.convert(students);
        Map<String, Student> expected = new HashMap<>();
        expected.put("Ivanov", new Student("Ivanov", 60));
        expected.put("Petrov", new Student("Petrov", 40));
        expected.put("Sidorov", new Student("Sidorov", 90));
        expected.put("Kozlov", new Student("Kozlov", 85));
        assertThat(result, is(expected));
    }

    @Test
    public void whenThereAreDuplicatedStudents() {
        List<Student> students = Arrays.asList(
                new Student("Ivanov", 60),
                new Student("Ivanov", 60),
                new Student("Sidorov", 90),
                new Student("Kozlov", 85));
        Map<String, Student> result = MapStudents.convert(students);
        Map<String, Student> expected = new HashMap<>();
        expected.put("Ivanov", new Student("Ivanov", 60));
        expected.put("Sidorov", new Student("Sidorov", 90));
        expected.put("Kozlov", new Student("Kozlov", 85));
        assertThat(result, is(expected));
    }

}