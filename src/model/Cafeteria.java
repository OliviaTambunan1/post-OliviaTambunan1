package model;

import java.util.ArrayList;
import java.util.List;

public class Cafeteria {
    private final List<MenuItem> menuList = new ArrayList<>();

    public void addMenu(MenuItem item) {
        menuList.add(item);
    }

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

    // Parameter OrderType telah dihapus
    public void processFinalOrder(List<OrderItem> cart, DeliveryMethod method) {
        if (cart.isEmpty()) {
            System.out.println("\n[Gagal] Keranjang kosong.");
            return;
        }

        double totalFoodCost = 0;
        System.out.println("\n========== STRUK PEMBAYARAN ==========");
        System.out.printf("Opsi Pengiriman: %s\n", method.getLabel()); // Hanya menampilkan opsi kirim
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