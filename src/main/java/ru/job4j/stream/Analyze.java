package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {
    public static double averageScore(Stream<Pupil> stream) {
        return stream.map(Pupil::getSubjects)
                .flatMap(Subjects -> Subjects.stream())
                .mapToInt(e -> e.getScore())
                .average().getAsDouble();
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream.map(pupil -> new Tuple(pupil.getName(),
                pupil.getSubjects()
                        .stream()
                        .mapToInt(Subject::getScore)
                        .average().getAsDouble()
        )).collect(Collectors.toList());

    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        //Метод averageScoreByPupil вычисляет средний балл по всем предметам для каждого ученика.
        //Возвращает список из объекта Tuple (название предмета и средний балл).
        stream.map(Pupil::getSubjects)
                .flatMap(Subjects -> Subjects.stream()).
        return null;
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream.map(pupil -> new Tuple(pupil.getName(), pupil.getSubjects()
               .stream()
               .mapToInt(Subject::getScore)
                .sum()))
                        .max(Comparator.comparing(Tuple::getScore)).get();
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        //Метод bestSubject - возвращает предмет с наибольшим баллом для всех студентов.
        //Возвращает объект Tuple (имя предмета, сумма баллов каждого ученика по этому предмету)
        return null;
    }
}
