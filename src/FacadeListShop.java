public class FacadeListShop {
    Shopping_list_single_Ton_class shopping_List_ST = Shopping_list_single_Ton_class.getInstance();
    ShoppingListProxy shopping_List_Proxy = new ShoppingListProxy();
    ShoppingCartVisitor visitor = new ShoppingCartVisitorImpl();

    public void Facade_Add_Item_ST(String item) {
        shopping_List_ST.addItem(item);
    }

    public boolean Facade_remove_Item_ST(String item) {
        return shopping_List_ST.removeItem(item);
    }

    public String Facade_remove_Item_ST(int index) {
        return shopping_List_ST.removeItem(index);
    }

    public void Facade_Print_Item_ST() {
        shopping_List_ST.printList();
    }


    public void Facade_Add_Item_Proxy(String item) {
        shopping_List_Proxy.addItem(item);
    }

    public boolean Facade_remove_Item_Proxy(String item) {
        return shopping_List_Proxy.removeItem(item);
    }

    public String Facade_remove_Item_Proxy(int index) {
        return shopping_List_ST.removeItem(index);
    }

    public void Facade_Print_Item_Proxy() {
        shopping_List_Proxy.printList();
    }


    public void Facade_Visit_Item(Item item) {
        item.accept(visitor);
    }

    private static int Facade_Item_Calc(ItemElement[] items) {
        ShoppingCartVisitor visitor = new ShoppingCartVisitorImpl();
        int sum = 0;
        for (ItemElement item : items) {
            sum = sum + item.accept(visitor);
        }
        return sum;
    }


}
