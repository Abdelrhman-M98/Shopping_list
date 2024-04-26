import java.util.ArrayList;

public class Shopping_list_single_Ton_class {
    //Create a variable from type Single to return the value in it for one time
    private static Shopping_list_single_Ton_class instance = null;


    private final ArrayList<String> shoppingList;

    //private constructor create a list
    private Shopping_list_single_Ton_class() {
        shoppingList = new ArrayList<>();
    }

    // function return instance
    public static Shopping_list_single_Ton_class getInstance() {
        if (instance == null) {
            instance = new Shopping_list_single_Ton_class();
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
