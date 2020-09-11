package ru.job4j.stream;

import org.junit.Test;
import java.util.List;
import java.util.function.Predicate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SchoolTest {

    @Test
    public void whenStudentsSortedInClassA() {
        List<Student> students = List.of(
                new Student("Ivanov", 90),
                new Student("Petrov", 68),
                new Student("Sidorov", 33)
        );
        Predicate<Student> predict = new Predicate<>() {
            @Override
            public boolean test(Student n) {
                if (n.getScore() >= 70 && n.getScore() <= 100) {
                    return true;
                }
                return false;
            }
        };

        List<Student> result = School.collect(students, predict);
        List<Student> expected = List.of(
                new Student("Ivanov", 90));
        assertThat(result, is(expected));
    }

    @Test
    public void whenStudentsSortedInClassB() {
        List<Student> students = List.of(
                new Student("Ivanov", 70),
                new Student("Petrov", 50),
                new Student("Sidorov", 65)
        );
        Predicate<Student> predict = new Predicate<>() {
            @Override
            public boolean test(Student n) {
                if (n.getScore() >= 50 && n.getScore() < 70) {
                    return true;
                }
                return false;
            }
        };

        List<Student> result = School.collect(students, predict);
        List<Student> expected = List.of(
                new Student("Petrov", 50),
                new Student("Sidorov", 65));
        assertThat(result, is(expected));
    }

    @Test
    public void whenStudentsSortedInClassC() {
        List<Student> students = List.of(
                new Student("Ivanov", 70),
                new Student("Petrov", 50),
                new Student("Sidorov", 40)
        );
        Predicate<Student> predict = new Predicate<>() {
            @Override
            public boolean test(Student n) {
                if (n.getScore() > 0 && n.getScore() < 50) {
                    return true;
                }
                return false;
            }
        };

        List<Student> result = School.collect(students, predict);
        List<Student> expected = List.of(
                new Student("Sidorov", 40));
        assertThat(result, is(expected));
    }
}