package ru.job4j.tracker;

public class FindItemByNameAction implements UserAction {
    @Override
    public String name() {
        return "=== Find Item by name ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter name: ");
        Item[] item = tracker.findByName(name);
        if (item.length == 0) {
            System.out.print("Item is not found.");
        } else{
            for (Item i : item) {
                System.out.println(i);
            }
        }
        return true;
    }
}
