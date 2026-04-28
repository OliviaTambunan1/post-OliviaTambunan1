package model;

public class Model2 {
    // Nested Enum untuk Kategori
    public enum Category {
        SEMBAKO, SERAGAM
    }

    // Nested Enum untuk Produk beserta data statisnya
    public enum Product {
        DASI_SD("Dasi SD", 22, Category.SERAGAM),
        GULA("Gula", 85, Category.SEMBAKO),
        ROK_PRAMUKA("Rok Pramuka", 5, Category.SERAGAM),
        MINYAK("Minyak", 120, Category.SEMBAKO);

        private final String name;
        private final int stock;
        private final Category category;

        Product(String name, int stock, Category category) {
            this.name = name;
            this.stock = stock;
            this.category = category;
        }

        public int getStock() { return stock; }
        public Category getCategory() { return category; }
    }

    // Method untuk menghitung total stok
    public static int calculateTotalStock(Category target) {
        int total = 0;
        for (Product p : Product.values()) {
            if (p.getCategory() == target) {
                total += p.getStock();
            }
        }
        return total;
    }
}