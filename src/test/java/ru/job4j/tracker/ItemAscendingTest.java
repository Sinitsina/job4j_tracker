package ru.job4j.tracker;


import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ItemAscendingTest {
    @Test
    public void whenAscendingOrder() {
        List<Item> items = Arrays.asList(
                new Item("First Item"),
                new Item("Second Item"),
                new Item("Fifth Item")
        );
        Collections.sort(items, new SortItemByName());
        assertThat(items.toString(), is("[Item{id=0, name='Fifth Item'}, " +
                "Item{id=0, name='First Item'}, " +
                "Item{id=0, name='Second Item'}]"));
    }

    @Test
    public void whenDescendingOrder() {
        List<Item> items = Arrays.asList(
                new Item("First Item"),
                new Item("Second Item"),
                new Item("Fifth Item")
        );
        Comparator nameComparator = new SortItemByName();
        Collections.sort(items, nameComparator.reversed());
        assertThat(items.toString(), is("[Item{id=0, name='Second Item'}, " +
                "Item{id=0, name='First Item'}, " +
                "Item{id=0, name='Fifth Item'}]"));
    }

}