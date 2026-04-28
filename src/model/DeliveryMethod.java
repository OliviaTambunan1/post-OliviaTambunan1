package model;

public enum DeliveryMethod {
    PICK_UP("Ambil Sendiri", 0),
    DELIVERY("Diantar", 2000);

    private final String label;
    private final double fee;

    DeliveryMethod(String label, double fee) {
        this.label = label;
        this.fee = fee;
    }

    public String getLabel() { return label; }
    public double getFee() { return fee; }
}