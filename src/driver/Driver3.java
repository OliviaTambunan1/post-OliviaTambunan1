package driver;

import model.Model3;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver3 {
    public static void main(String[] args) {
        Model3 kafetaria = new Model3();
        kafetaria.addMenu(new Model3.Food("Nasi Goreng", 15000, 10));
        kafetaria.addMenu(new Model3.Food("Mie Pangsit", 12000, 5));
        kafetaria.addMenu(new Model3.Drink("Es Teh", 5000, 20));

        Scanner scanner = new Scanner(System.in);
        List<Model3.OrderItem> cart = new ArrayList<>();
        
        kafetaria.displayMenu();

        while (true) {
            System.out.print("Pilih Menu (atau ketik 'Selesai' untuk checkout): ");
            String input = scanner.nextLine();
            
            if (input.equalsIgnoreCase("Selesai")) break;

            Model3.MenuItem selected = kafetaria.findMenu(input);
            if (selected == null) {
                System.out.println("Menu tidak ditemukan!");
                continue;
            }

            System.out.print("Jumlah untuk " + selected.getName() + ": ");
            int qty = Integer.parseInt(scanner.nextLine());

            if (selected.isAvailable(qty)) {
                cart.add(new Model3.OrderItem(selected, qty));
                System.out.println("Berhasil ditambah ke keranjang.\n");
            } else {
                System.out.println("Stok tidak cukup! Sisa: " + selected.getStock() + "\n");
            }
        }

        if (!cart.isEmpty()) {
            System.out.print("\nKirim (1: Ambil Sendiri, 2: Diantar): ");
            int deliveryChoice = Integer.parseInt(scanner.nextLine());
            Model3.DeliveryMethod method = (deliveryChoice == 2) 
                ? Model3.DeliveryMethod.DELIVERY 
                : Model3.DeliveryMethod.PICK_UP;

            kafetaria.processFinalOrder(cart, method);
        }
        scanner.close();
    }
}