package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    private final Output out;

    public ReplaceAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Replace";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Replace an Item ====");
        int id = Integer.parseInt(input.askStr("Enter id: "));
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        item.setId(id);
        if (tracker.replace(id, item)) {
            out.println("Item with id " + id + " was successfully replaced.");
        } else {
            out.println("Unfortunately Item with id " + id + " was not found and replaced.");
        }
        return true;
    }
}
