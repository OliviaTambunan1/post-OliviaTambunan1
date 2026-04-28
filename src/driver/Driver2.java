package driver;

import model.Model2;
import java.util.Scanner;

public class Driver2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Pengecekan Total Stok Gudang ===");
        System.out.println("Kategori: SEMBAKO, SERAGAM");
        
        System.out.print("Masukkan Kategori: ");
        String input = scanner.nextLine().trim().toUpperCase();

        try {
            Model2.Category reqCategory = Model2.Category.valueOf(input);
            int total = Model2.calculateTotalStock(reqCategory);
            
            System.out.println("------------------------------------");
            System.out.printf("Total stok %s : %d pcs\n", reqCategory.name(), total);
            System.out.println("------------------------------------");
        } catch (IllegalArgumentException e) {
            System.out.println("\n[Error] Kategori tidak ditemukan.");
        }
        scanner.close();
    }
}