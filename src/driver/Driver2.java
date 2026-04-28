package driver;

import model.Category;
import model.Product;
import java.util.Scanner;

public class Driver2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Membaca input kategori (Contoh input: "SEMBAKO" atau "SERAGAM")
        if (scanner.hasNext()) {
            String input = scanner.next().trim().toUpperCase();
            
            try {
                Category requestedCategory = Category.valueOf(input);
                int totalStock = Product.calculateTotalStockByCategory(requestedCategory);
                
                // Format output rapi, langsung menampilkan hasil angka untuk autograder
                System.out.println(totalStock);
                
            } catch (IllegalArgumentException e) {
                // Menangani jika input kategori tidak sesuai dengan Enum
                System.out.println("0"); 
            }
        }
        
        scanner.close();
    }
}
