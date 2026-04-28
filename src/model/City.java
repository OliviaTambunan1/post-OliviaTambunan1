package model;

public enum City {
    MDN("Medan", 8000.0, Region.DALAM_PULAU),
    BLG("Balige", 5000.0, Region.DALAM_PULAU),
    JKT("Jakarta", 12000.0, Region.LUAR_PULAU),
    SBY("Surabaya", 13000.0, Region.LUAR_PULAU);

    private final String cityName;
    private final double costPerKg;
    private final Region region;

    City(String cityName, double costPerKg, Region region) {
        this.cityName = cityName;
        this.costPerKg = costPerKg;
        this.region = region;
    }

    public String getCityName() { return cityName; }
    public double getCostPerKg() { return costPerKg; }
    public Region getRegion() { return region; }
}