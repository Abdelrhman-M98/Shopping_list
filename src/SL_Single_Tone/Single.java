package SL_Single_Tone;

import java.util.ArrayList;

public class Single {
    //Create a variable from type Single to return the value in it for one time
    private static Single instance = null;


    private final ArrayList<String> shoppingList;

    //private constructor create a list
    private Single() {
        shoppingList = new ArrayList<>();
    }

    // function return instance
    public static Single getInstance() {
        if (instance == null) {
            instance = new Single();
        }
        return instance;
    }

    public void addItem(String item) {
        shoppingList.add(item);
    }

    public String removeItem(int index) {
        if (index >= 1 && index <= shoppingList.size()) {
            return shoppingList.remove(index - 1);
        } else {
            return null;
        }
    }

    public boolean removeItem(String item) {
        return shoppingList.remove(item);
    }


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
