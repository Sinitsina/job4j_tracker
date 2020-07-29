package ru.job4j.tracker;

public class ShowAction implements UserAction {
    @Override
    public String name() {
        return "=== Show all Items ====";
    }

    @Override
    public boolean execute (Input input, Tracker tracker) {
        for (Item i : tracker.findAll()) {
            System.out.println(i);
        }
        return true;
    }
}
