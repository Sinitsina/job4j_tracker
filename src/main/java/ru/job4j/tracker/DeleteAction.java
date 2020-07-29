package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "=== Delete an Item ====";
    }
    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = Integer.valueOf(input.askStr("Enter id: "));
        if (tracker.delete(id)) {
            System.out.println("Item with id " + id + "was successfully deleted.");
        } else {
            System.out.println("Unfortunately Item with id " + id + "was not found and deleted.");
        }
        return true;
    }
}
