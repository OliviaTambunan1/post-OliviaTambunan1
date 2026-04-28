package driver;

import model.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver3 {
    public static void main(String[] args) {
        Cafeteria kafetaria = new Cafeteria();
        kafetaria.addMenu(new Food("Nasi Goreng", 15000, 10));
        kafetaria.addMenu(new Food("Mie Pangsit", 12000, 5));
        kafetaria.addMenu(new Drink("Es Teh", 5000, 20));

        Scanner scanner = new Scanner(System.in);
        List<OrderItem> cart = new ArrayList<>();
        
        kafetaria.displayMenu();

        while (true) {
            System.out.print("Pilih Menu (atau ketik 'Selesai' untuk checkout): ");
            String input = scanner.nextLine();
            
            if (input.equalsIgnoreCase("Selesai")) break;

            MenuItem selected = kafetaria.findMenu(input);
            if (selected == null) {
                System.out.println("Menu tidak ditemukan!");
                continue;
            }

            System.out.print("Jumlah untuk " + selected.getName() + ": ");
            int qty = Integer.parseInt(scanner.nextLine());

            if (selected.isAvailable(qty)) {
                cart.add(new OrderItem(selected, qty));
                System.out.println("Berhasil ditambah ke keranjang.");
            } else {
                System.out.println("Stok tidak cukup! Sisa: " + selected.getStock());
            }
            System.out.println();
        }

        if (!cart.isEmpty()) {
            // Input metode (Manual/WA) sudah dihapus total di sini
            
            System.out.print("Kirim (1: Ambil, 2: Antar)  : ");
            int deliveryChoice = Integer.parseInt(scanner.nextLine());
            DeliveryMethod method = (deliveryChoice == 2) ? DeliveryMethod.DELIVERY : DeliveryMethod.PICK_UP;

            // Memanggil method tanpa argumen OrderType
            kafetaria.processFinalOrder(cart, method);
        }

        scanner.close();
    }
}