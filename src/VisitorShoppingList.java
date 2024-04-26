interface ItemElement {
    int accept(ShoppingCartVisitor visitor);
}

class Item implements ItemElement {
    private String name;
    private double price;
    private int quantity;

    public Item(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public int accept(ShoppingCartVisitor visitor) {
        return visitor.visit(this);
    }
}

interface ShoppingCartVisitor {
    int visit(Item item);
}

class ShoppingCartVisitorImpl implements ShoppingCartVisitor {
    @Override
    public int visit(Item item) {
        double cost = item.getPrice() * item.getQuantity();
        System.out.println(item.getName() + " cost = " + cost);
        return (int) cost;
    }



}