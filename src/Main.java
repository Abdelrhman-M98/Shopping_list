import SL_Single_Ton.Shopping_list_single_Ton_class;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Shopping_list_single_Ton_class shoppingList = Shopping_list_single_Ton_class.getInstance();

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Welcome to your shopping list !");

            while (true) {
                System.out.println("Enter 'a' to add an item, 'r' to remove an item, 'p' to print your list, or 'q' to quit:");
                String input = scanner.nextLine();
                switch (input) {
                    case "q":
                        return;
                    case "p":
                        shoppingList.printList();
                        break;
                    case "a":
                        System.out.println("Enter the item you want to add:");
                        String item = scanner.nextLine();
                        shoppingList.addItem(item);
                        break;
                    case "r":
                        System.out.println("Enter 'n' to remove by item name or 'i' to remove by item number:");
                        String option = scanner.nextLine();
                        if (option.equalsIgnoreCase("n")) {
                            System.out.println("Enter the name of the item you want to remove:");
                            String itemName = scanner.nextLine();
                            boolean removed = shoppingList.removeItem(itemName);
                            if (removed) {
                                System.out.println(itemName + " has been removed from your list.");
                            } else {
                                System.out.println("Item not found in the list.");
                            }
                        } else if (option.equalsIgnoreCase("i")) {
                            System.out.println("Enter the number of the item you want to remove:");
                            int index = scanner.nextInt();
                            scanner.nextLine();
                            String removedItem = shoppingList.removeItem(index);
                            if (removedItem != null) {
                                System.out.println(removedItem + " has been removed from your list.");
                            } else {
                                System.out.println("Invalid input.");
                            }
                        } else {
                            System.out.println("Invalid option.");
                        }
                        break;

                    default:
                        System.out.println("Invalid input.");
                        break;
                }
            }
        }
    }
}
