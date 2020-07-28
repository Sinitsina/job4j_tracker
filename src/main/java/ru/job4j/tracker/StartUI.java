package ru.job4j.tracker;

public class StartUI {
    public void init(Input input, Tracker tracker) {
        boolean run = false;
        while (run) {
            this.showMenu();
            int select = Integer.valueOf(input.askStr("Select: "));
            if (select == 0) {
                StartUI.createItem(input, tracker);
            } else if (select == 1) {
                StartUI.showItem(tracker);
            } else if (select == 2) {
                StartUI.deleteItem(input, tracker);
            } else if (select == 3) {
                StartUI.replaceItem(input, tracker);
            } else if (select == 4) {
                StartUI.findItemById(input, tracker);
            } else if (select == 5) {
                StartUI.findItemByName(input, tracker);
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu."
                + "\n" + "0. Add new Item"
                + "\n" + "1. Show all items"
                + "\n" + "2. Edit item"
                + "\n" + "3. Delete item"
                + "\n" + "4. Find item by Id"
                + "\n" + "5. Find items by name"
                + "\n" + "6. Exit Program"
                + "\n" + "Select:");
    }


    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
    }

    public static void showItem(Tracker tracker) {
        for (Item i : tracker.findAll()) {
            System.out.println(i);
        }
    }
    public static void deleteItem(Input input, Tracker tracker) {
        int id = Integer.valueOf(input.askStr("Enter id: "));
        if (tracker.delete(id)) {
            System.out.println("Item with id " + id + "was successfully deleted.");
        } else {
            System.out.println("Unfortunately Item with id " + id + "was not found and deleted.");
        }
    }

    public static void replaceItem(Input input, Tracker tracker) {
        int id = Integer.parseInt(input.askStr("Enter id: "));
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        item.setId(id);
        if (tracker.replace(id, item)) {
            System.out.println("Item with id " + id + " was successfully replaced.");
        } else {
            System.out.println("Unfortunately Item with id " + id + " was not found and replaced.");
        }
    }

    public static void findItemById(Input input, Tracker tracker) {
        int id = Integer.parseInt(input.askStr("Enter id: "));
        Item item = tracker.findById(id);
        if (item == null) {
            System.out.print("Id is not found.");
        } else {
            System.out.print(item);
        }
    }

    public static void findItemByName(Input input, Tracker tracker) {
        String name = input.askStr("Enter name: ");
        Item[] item = tracker.findByName(name);
        if (item.length == 0) {
            System.out.print("Item is not found.");
        } else{
            for (Item i : item) {
                System.out.println(i);
            }
        }
    }
}
