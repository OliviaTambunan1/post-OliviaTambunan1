package model;

public class Food extends MenuItem {
    public Food(String name, double price, int stock) {
        super(name, price, stock);
    }

    @Override
    public String getCategory() {
        return "Makanan";
    }
}