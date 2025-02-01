package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

public abstract class Stock implements Tradeable {
    String name;
    double price;
    String description;
    List<Double> prevPrices; // Store previous prices

    public Stock(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.prevPrices = new ArrayList<>();
        this.prevPrices.add(price); // Add initial price to history
    }

    @Override
    public String toString() {
        return String.format("Stock [name=%s, price=%.2f, description=%s]", name, price, description);
    }


    @Override
    public double getMetric() {
    	if (prevPrices.size() < 2) {
            return 0; // Not enough data for calculation
        }
        double mean = prevPrices.stream().mapToDouble(i -> i).average().orElse(0.0);
        double deviationSum = 0.0;

        for (double num : prevPrices) {
            deviationSum += (num - mean);
        }
        double avgDeviation = deviationSum / prevPrices.size();
        return avgDeviation > 0.5 ? 1 : -1;
    }
    


    public void recordPrice() {
        prevPrices.add(this.price);
        if (prevPrices.size() > 6) {
            prevPrices.remove(0); // Keep history limited to 6 prices
        }
    }
}
