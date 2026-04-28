package model;

public class Model1 {
    // Nested Enum untuk Kota
    public enum City {
        MDN("Medan", 8000.0, "Dalam Pulau"),
        BLG("Balige", 5000.0, "Dalam Pulau"),
        JKT("Jakarta", 12000.0, "Luar Pulau"),
        SBY("Surabaya", 13000.0, "Luar Pulau");

        private final String name;
        private final double costPerKg;
        private final String region;

        City(String name, double costPerKg, String region) {
            this.name = name;
            this.costPerKg = costPerKg;
            this.region = region;
        }

        public String getName() { return name; }
        public double getCostPerKg() { return costPerKg; }
        public String getRegion() { return region; }
    }

    private final City city;
    private final double weightButet;
    private final double weightUcok;

    public Model1(City city, double weightButet) {
        this.city = city;
        this.weightButet = weightButet;
        this.weightUcok = 1.5 * weightButet; // Ucok = 3/2 Butet
    }

    public double getTotalWeight() { return weightButet + weightUcok; }
    public double getBaseCost() { return getTotalWeight() * city.getCostPerKg(); }
    public double getWeightButet() { return weightButet; }
    public double getWeightUcok() { return weightUcok; }
    public City getCity() { return city; }
}