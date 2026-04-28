package model;

// Record adalah fitur Java modern (JDK 14+) untuk data carrier yang ringkas
public record OrderItem(MenuItem item, int quantity) {
    public double getSubTotal() {
        return item.getPrice() * quantity;
    }
}