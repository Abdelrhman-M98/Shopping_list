import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        FacadeListShop Interface = new FacadeListShop();
        boolean Patter_Flag = false;
        boolean Loop_Flag = false;

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Welcome to your shopping list !");
            //System.out.println("1)Single Ton" + "\n" + "2)Proxy" + "\n" + "3)Visitor" + "\n" + "0)Exit" + "\n");
            while (!Patter_Flag) {
                System.out.println("1)Single Ton" + "\n" + "2)Proxy" + "\n" + "3)Visitor" + "\n" + "0)Exit" + "\n");
                short input_Pattern = scanner.nextShort();
                scanner.nextLine();
                Loop_Flag = false;
                switch (input_Pattern) {
                    case 1:
                        while (!Loop_Flag) {
                            System.out.println("Enter 'a' to add an item, 'r' to remove an item, 'p' to print your list, or 'q' to quit:");
                            String input = scanner.nextLine();
                            switch (input) {
                                case "q":
                                    Loop_Flag = true;
                                    break;
                                case "p":
                                    Interface.Facade_Print_Item_ST();
                                    break;
                                case "a":
                                    System.out.println("Enter the item you want to add:");
                                    String item = scanner.nextLine();
                                    Interface.Facade_Add_Item_ST(item);
                                    break;
                                case "r":
                                    System.out.println("Enter 'n' to remove by item name or 'i' to remove by item number:");
                                    String option = scanner.nextLine();
                                    if (option.equalsIgnoreCase("n")) {
                                        System.out.println("Enter the name of the item you want to remove:");
                                        String itemName = scanner.nextLine();
                                        boolean removed = Interface.Facade_remove_Item_ST(itemName);
                                        if (removed) {
                                            System.out.println(itemName + " has been removed from your list.");
                                        } else {
                                            System.out.println("Item not found in the list.");
                                        }
                                    } else if (option.equalsIgnoreCase("i")) {
                                        System.out.println("Enter the number of the item you want to remove:");
                                        int index = scanner.nextInt();
                                        scanner.nextLine();
                                        String removedItem = Interface.Facade_remove_Item_ST(index);
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

                    case 2:
                        while (!Loop_Flag) {
                            System.out.println("Enter 'a' to add an item, 'r' to remove an item, 'p' to print your list, or 'q' to quit:");
                            String input = scanner.nextLine();
                            switch (input) {
                                case "q":
                                    Loop_Flag = true;
                                    break;
                                case "p":
                                    Interface.Facade_Print_Item_Proxy();
                                    break;
                                case "a":
                                    System.out.println("Enter the item you want to add:");
                                    String item = scanner.nextLine();
                                    Interface.Facade_Add_Item_Proxy(item);
                                    break;
                                case "r":
                                    System.out.println("Enter 'n' to remove by item name or 'i' to remove by item number:");
                                    String option = scanner.nextLine();
                                    if (option.equalsIgnoreCase("n")) {
                                        System.out.println("Enter the name of the item you want to remove:");
                                        String itemName = scanner.nextLine();
                                        boolean removed = Interface.Facade_remove_Item_Proxy(itemName);
                                        if (removed) {
                                            System.out.println(itemName + " has been removed from your list.");
                                        } else {
                                            System.out.println("Item not found in the list.");
                                        }
                                    } else if (option.equalsIgnoreCase("i")) {
                                        System.out.println("Enter the number of the item you want to remove:");
                                        int index = scanner.nextInt();
                                        scanner.nextLine();
                                        String removedItem = Interface.Facade_remove_Item_Proxy(index);
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
                        break;
                    case 3:
                        while (!Loop_Flag) {
                            System.out.println("Enter 'a' to add an item, 'q' to quit:");
                            String input = scanner.nextLine();
                            switch (input) {
                                case "q":
                                    Loop_Flag = true;
                                    break;
                                case "a":
                                    System.out.println("Enter the item name:");
                                    String Name = scanner.nextLine();
                                    System.out.println("Enter the item Price:");
                                    int itemPrice = scanner.nextInt();
                                    System.out.println("Enter the item Quantity:");
                                    int itemQuantity = scanner.nextInt();
                                    scanner.nextLine(); // Consume newline character
                                    Item item = new Item(Name, itemPrice, itemQuantity);
                                    Interface.Facade_Visit_Item(item);
                                    break;
                                default:
                                    System.out.println("Invalid input.");
                                    break;
                            }
                        }
                        break;
                    case 0:
                        Patter_Flag = true;
                        break;
                    default:
                        System.out.println("Invalid input.");
                        break;
                }
            }
        }
    }
}