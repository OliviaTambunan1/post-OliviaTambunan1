package model;

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

    public String getName() { return name; }
    public int getStock() { return stock; }
    public Category getCategory() { return category; }

    // Method untuk menghitung total stok berdasarkan kategori yang diminta
    public static int calculateTotalStockByCategory(Category targetCategory) {
        int totalStock = 0;
        for (Product product : Product.values()) {
            if (product.getCategory() == targetCategory) {
                totalStock += product.getStock();
            }
        }
        return totalStock;
    }
}