package model;

import java.util.ArrayList;
import java.util.List;

public class Model3 {
    public enum DeliveryMethod {
        PICK_UP("Ambil Sendiri", 0),
        DELIVERY("Diantar", 2000);

        private final String label;
        private final double fee;

        DeliveryMethod(String label, double fee) { 
            this.label = label; 
            this.fee = fee; 
        }
        public String getLabel() { return label; }
        public double getFee() { return fee; }
    }

    // Nested Abstract Class
    public static abstract class MenuItem {
        protected String name;
        protected double price;
        protected int stock;

        public MenuItem(String name, double price, int stock) {
            this.name = name; this.price = price; this.stock = stock;
        }
        public String getName() { return name; }
        public double getPrice() { return price; }
        public int getStock() { return stock; }
        public boolean isAvailable(int qty) { return stock >= qty; }
        public void reduceStock(int qty) { if (isAvailable(qty)) stock -= qty; }
    }

    // Inheritance
    public static class Food extends MenuItem {
        public Food(String name, double price, int stock) { super(name, price, stock); }
    }

    public static class Drink extends MenuItem {
        public Drink(String name, double price, int stock) { super(name, price, stock); }
    }

    // Nested Record (Data Carrier)
    public record OrderItem(MenuItem item, int quantity) {
        public double getSubTotal() { return item.getPrice() * quantity; }
    }

    private final List<MenuItem> menuList = new ArrayList<>();

    public void addMenu(MenuItem item) { menuList.add(item); }

    public void displayMenu() {
        System.out.println("\n=== Menu Kafetaria IT Del ===");
        for (MenuItem item : menuList) {
            System.out.printf("- %-15s | Rp%,.0f | Stok: %d\n", 
                item.getName(), item.getPrice(), item.getStock());
        }
        System.out.println("===============================");
    }

    public MenuItem findMenu(String name) {
        for (MenuItem item : menuList) {
            if (item.getName().equalsIgnoreCase(name.trim())) return item;
        }
        return null;
    }

    public void processFinalOrder(List<OrderItem> cart, DeliveryMethod method) {
        if (cart.isEmpty()) {
            System.out.println("\n[Gagal] Keranjang kosong.");
            return;
        }
        double totalFoodCost = 0;
        System.out.println("\n========== STRUK PEMBAYARAN ==========");
        System.out.printf("Opsi Pengiriman: %s\n", method.getLabel());
        System.out.println("--------------------------------------");
        for (OrderItem order : cart) {
            order.item().reduceStock(order.quantity());
            totalFoodCost += order.getSubTotal();
            System.out.printf("%-15s x%d | Rp%,.0f\n", 
                order.item().getName(), order.quantity(), order.getSubTotal());
        }
        double deliveryFee = method.getFee();
        System.out.println("--------------------------------------");
        System.out.printf("Subtotal Makanan : Rp%,.0f\n", totalFoodCost);
        System.out.printf("Biaya Antar      : Rp%,.0f\n", deliveryFee);
        System.out.printf("TOTAL AKHIR      : Rp%,.0f\n", (totalFoodCost + deliveryFee));
        System.out.println("======================================");
    }
}