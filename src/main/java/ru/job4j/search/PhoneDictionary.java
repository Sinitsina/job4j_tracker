package ru.job4j.search;

import java.util.ArrayList;

import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> checkName = u -> u.getName().contains(key);
        Predicate<Person> checkSurname = u -> u.getSurname().contains(key);
        Predicate<Person> checkAddress = u -> u.getAddress().contains(key);
        Predicate<Person> checkPhone = u -> u.getPhone().contains(key);
        Predicate<Person> combine = checkName.or(checkSurname).or(checkAddress).or(checkPhone);
        var result = new ArrayList<Person>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
