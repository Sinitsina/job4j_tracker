package ru.job4j.tracker;
import java.util.*;

public class FindItemByNameAction implements UserAction {
    private final Output out;

    public FindItemByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find Item by name ====");
        String name = input.askStr("Enter name: ");
        List<Item> item = tracker.findByName(name);
        if (item.size() == 0) {
            out.println("Item is not found.");
        } else{
            for (Item i : item) {
                out.println(i);
            }
        }
        return true;
    }
}
