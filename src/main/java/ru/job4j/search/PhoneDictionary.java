package ru.job4j.search;

import java.util.ArrayList;

import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> checkName = u -> u.getName().contains(key);
        Predicate<Person> checkSurname = u -> u.getSurname().contains(key);
        Predicate<Person> checkAddress = u -> u.getAddress().contains(key);
        Predicate<Person> checkPhone = u -> u.getPhone().contains(key);
        Predicate<Person> filter1 = checkName.or(checkSurname);
        Predicate<Person> filter2 = checkAddress.or(checkPhone);
        Predicate<Person> combine = filter1.or(filter2);
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
