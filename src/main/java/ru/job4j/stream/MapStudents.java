package ru.job4j.stream;

import java.util.*;
import java.util.stream.Collectors;

public class MapStudents {
    private List<Student> students = Arrays.asList(
            new Student("Ivanov", 60),
            new Student("Petrov", 40),
            new Student("Sidorov", 90),
            new Student("Kozlov", 85));

    static Map<String, Student> convert(List<Student> students) {
        return students.stream().collect(
                Collectors.toMap(
                        e -> e.getSurname(),
                        e -> e,
                        (e, duplicate) -> e
                ));
    }
}
