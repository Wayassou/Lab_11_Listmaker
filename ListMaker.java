import java.util.ArrayList;

public class ListMaker {

    private static ArrayList<String> myList = new ArrayList<>();

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            displayList();
            char command = SafeInput.getRegExString("Choose an option [A, D, I, P, Q]:", "[AaDdIiPpQq]").toUpperCase().charAt(0);
            switch (command) {
                case 'A':
                    addItem();
                    break;
                case 'D':
                    deleteItem();
                    break;
                case 'I':
                    insertItem();
                    break;
                case 'P':
                    printList();
                    break;
                case 'Q':
                    if (SafeInput.getYNConfirm("Are you sure you want to quit?")) {
                        running = false;
                    }
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }
    }

    private static void displayList() {
        System.out.println("\nCurrent List:");
        for (int i = 0; i < myList.size(); i++) {
            System.out.printf("%d: %s%n", i + 1, myList.get(i));
        }
        System.out.println();
    }

    private static void addItem() {
        String newItem = SafeInput.getNonZeroLenString("Enter item to add:");
        myList.add(newItem);
    }

    private static void deleteItem() {
        if (myList.isEmpty()) {
            System.out.println("List is empty, nothing to delete.");
            return;
        }
        int index = SafeInput.getRangedInt("Enter item number to delete:", 1, myList.size()) - 1;
        myList.remove(index);
    }

    private static void insertItem() {
        if (myList.isEmpty()) {
            System.out.println("List is empty, nothing to insert.");
            return;
        }
        int index = SafeInput.getRangedInt("Enter position to insert the item:", 1, myList.size() + 1) - 1;
        String newItem = SafeInput.getNonZeroLenString("Enter item to insert:");
        myList.add(index, newItem);
    }

    private static void printList() {
        System.out.println("\nList Contents:");
        for (String item : myList) {
            System.out.println(item);
        }
    }
}

