package model;

public class Drink extends MenuItem {
    public Drink(String name, double price, int stock) {
        super(name, price, stock);
    }

    @Override
    public String getCategory() {
        return "Minuman";
    }
}