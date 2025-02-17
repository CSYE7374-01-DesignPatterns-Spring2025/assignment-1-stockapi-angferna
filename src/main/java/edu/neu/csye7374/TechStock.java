package edu.neu.csye7374;

public class TechStock extends Stock {
    private double bid;

    public TechStock(String name, double price, String description) {
        super(name, price, description);
    }

    @Override
    public void setBid(double bid) {
        this.price += bid * 0.05; // Example of price change logic
        recordPrice(); // Store new price in history
    }

}