package ru.job4j.tracker;

public class FindItemByIdAction implements UserAction {
    private final Output out;

    public FindItemByIdAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find by id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find Item by ID ====");
        int id = Integer.parseInt(input.askStr("Enter id: "));
        Item item = tracker.findById(id);
        if (item == null) {
            out.println("Id is not found.");
        } else {
            out.println(item);
        }
        return true;
    }
}
