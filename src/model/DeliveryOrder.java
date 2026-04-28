package model;

public class DeliveryOrder {
    private final City destination;
    private final double weightButet;
    private final double weightUcok;

    public DeliveryOrder(City destination, double weightButet) {
        this.destination = destination;
        this.weightButet = weightButet;
        this.weightUcok = 1.5 * weightButet; // Ucok = 3/2 x berat Butet
    }

    public double getTotalWeight() {
        return weightButet + weightUcok;
    }

    public double getBaseCost() {
        return getTotalWeight() * destination.getCostPerKg();
    }

    public boolean isPromoEligible() {
        return getTotalWeight() > 10.0 && destination.getRegion() == Region.LUAR_PULAU;
    }

    public double getDiscount() {
        return isPromoEligible() ? getBaseCost() * 0.10 : 0.0;
    }

    public String getInsuranceStatus() {
        return isPromoEligible() ? "Gratis Asuransi" : "Tidak Asuransi";
    }

    public double getFinalCost() {
        return getBaseCost() - getDiscount();
    }
    
    // Getters untuk rincian
    public double getWeightButet() { return weightButet; }
    public double getWeightUcok() { return weightUcok; }
}