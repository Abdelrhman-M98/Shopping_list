import java.util.ArrayList;
import java.util.List;

// Subject Interface
interface ShoppingList {
    void addItem(String item);
    String removeItem(int index);
    boolean removeItem(String item);
    void printList();
}

// Real Object
class RealShoppingList implements ShoppingList {
    private ArrayList<String> shoppingList = new ArrayList<>();
    private List<String> restrictedItems = new ArrayList<>();

    public RealShoppingList() {
        // Manually adding items to restrictedItems list
        restrictedItems.add("tobacco");
        restrictedItems.add("alcohol");
        restrictedItems.add("fireworks");
    }


    @Override
    public void addItem(String item) {
        // Check if the item is in the list of restricted items
        if (restrictedItems.contains(item)) {
            System.out.println("Item '" + item + "' cannot be added to the shopping list.");
            return; // Skip adding the item
        }
        shoppingList.add(item);
    }


    @Override
    public String removeItem(int index) {
        if (index >= 1 && index <= shoppingList.size()) {
            return shoppingList.remove(index - 1);
        } else {
            return null;
        }
    }

    @Override
    public boolean removeItem(String item) {
        return shoppingList.remove(item);
    }

    @Override
    public void printList() {
        if (shoppingList.isEmpty()) {
            System.out.println("Your shopping list is empty.");
        } else {
            System.out.println("Here is your shopping list:");
            for (int i = 0; i < shoppingList.size(); i++) {
                System.out.println((i + 1) + ". " + shoppingList.get(i));
            }
        }
    }
}

// Proxy Object
class ShoppingListProxy implements ShoppingList {
    private RealShoppingList realShoppingList;

    public ShoppingListProxy() {
        realShoppingList = new RealShoppingList();
    }

    @Override
    public void addItem(String item) {
        // Additional logic before adding an item
        System.out.println("Adding item: " + item);
        realShoppingList.addItem(item);
    }

    @Override
    public String removeItem(int index) {
        // Additional logic before removing an item
        System.out.println("Removing item at index: " + index);
        return realShoppingList.removeItem(index);
    }

    @Override
    public boolean removeItem(String item) {
        // Additional logic before removing an item
        System.out.println("Removing item: " + item);
        return realShoppingList.removeItem(item);
    }

    @Override
    public void printList() {
        // Additional logic before printing the list
        System.out.println("Printing shopping list:");
        realShoppingList.printList();
    }
}
