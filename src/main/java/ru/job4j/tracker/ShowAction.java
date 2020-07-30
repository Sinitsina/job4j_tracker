package ru.job4j.tracker;

public class ShowAction implements UserAction {
    private final Output out;

    public ShowAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show";
    }

    @Override
    public boolean execute (Input input, Tracker tracker) {
        out.println("=== Show all Items ====");
        for (Item i : tracker.findAll()) {
            out.println(i);
        }
        return true;
    }
}
