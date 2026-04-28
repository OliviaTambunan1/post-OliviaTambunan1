package driver;

import model.Model1;
import java.util.Scanner;

public class Driver1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Kalkulator Ongkir Del-Express ===");
        
        System.out.print("Masukkan Kode Kota (MDN/BLG/JKT/SBY): ");
        String cityCode = scanner.next().trim().toUpperCase();
        
        System.out.print("Masukkan Berat Paket Butet (kg): ");
        double weight = scanner.nextDouble();

        try {
            Model1.City destination = Model1.City.valueOf(cityCode);
            Model1 order = new Model1(destination, weight);

            System.out.println("\n--- Hasil Perhitungan ---");
            System.out.printf("Tujuan       : %s\n", order.getCity().getName());
            System.out.printf("Berat Butet  : %.2f kg\n", order.getWeightButet());
            System.out.printf("Berat Ucok   : %.2f kg\n", order.getWeightUcok());
            System.out.printf("Total Berat  : %.2f kg\n", order.getTotalWeight());
            System.out.printf("Ongkos Dasar : Rp%,.2f\n", order.getBaseCost());
        } catch (IllegalArgumentException e) {
            System.out.println("\n[Error] Kode kota tidak valid.");
        }
        scanner.close();
    }
}
