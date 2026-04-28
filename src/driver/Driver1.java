package driver;

import model.City;
import model.DeliveryOrder;
import java.util.Scanner;

public class Driver1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Sistem Pengiriman Del-Express ===");
        System.out.print("Masukkan berat paket Butet (x kg): ");
        double weightButet = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Masukkan kode kota tujuan (MDN/BLG/JKT/SBY): ");
        String cityCode = scanner.nextLine().trim().toUpperCase();

        try {
            City destination = City.valueOf(cityCode);
            DeliveryOrder order = new DeliveryOrder(destination, weightButet);

            System.out.println("\n--- Rincian Ongkos Kirim ---");
            System.out.printf("Tujuan          : %s (%s)\n", destination.getCityName(), destination.getRegion());
            System.out.printf("Berat Butet     : %.2f kg\n", order.getWeightButet());
            System.out.printf("Berat Ucok      : %.2f kg\n", order.getWeightUcok());
            System.out.printf("Total Berat     : %.2f kg\n", order.getTotalWeight());
            System.out.printf("Ongkos Dasar    : Rp%.2f\n", order.getBaseCost());
            System.out.printf("Diskon Ongkir   : Rp%.2f\n", order.getDiscount());
            System.out.printf("Status Asuransi : %s\n", order.getInsuranceStatus());
            System.out.printf("Total Bayar     : Rp%.2f\n", order.getFinalCost());
            System.out.println("----------------------------");

        } catch (IllegalArgumentException e) {
            System.out.println("\n[Error] Kode kota tidak valid. Silakan gunakan MDN, BLG, JKT, atau SBY.");
        } finally {
            scanner.close();
        }
    }
}