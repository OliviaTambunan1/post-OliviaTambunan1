package model;

public abstract class MenuItem {
    protected String name;
    protected double price;
    protected int stock;

    public MenuItem(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getStock() { return stock; }

    public boolean isAvailable(int quantity) {
        return stock >= quantity;
    }

    public void reduceStock(int quantity) {
        if (isAvailable(quantity)) {
            stock -= quantity;
        }
    }

    // Abstract method untuk Polymorphism
    public abstract String getCategory(); 
}