package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public Item[] findAll() {
        return Arrays.copyOf(this.items, size);
    }

    public Item[] findByName(String key) {
        int sizeInner = 0;
        Item[] itemFoundNames = new Item[size];
        for (int index = 0; index < size; index++) {
            Item name = items[index];
            if (name.getName().equals(key)) {
                itemFoundNames[sizeInner] = name;
                sizeInner++;
            }
        }
        return Arrays.copyOf(itemFoundNames, sizeInner);
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        item.setId(id);
        boolean rsl = index != -1;
        if (rsl) {
            items[index] = item;
        }
        return rsl;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        int start = index + 1;
        int size1 = size - index;
        boolean rsl = index != -1;
        if (rsl) {
            System.arraycopy(items, start, items, index, size1);
            items[size - 1] = null;
            size--;
        }
        return rsl;
    }

    public Item[] getItems() {
        return items;
    }

}
