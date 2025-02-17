package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

public class StockMarket {
    private static StockMarket instance;
    private List<Stock> stocks;

    private StockMarket() {
        stocks = new ArrayList<>();
    }

    public static synchronized StockMarket getInstance() {
        if (instance == null) {
            instance = new StockMarket();
        }
        return instance;
    }

    public void addStock(Stock stock) {
        stocks.add(stock);
    }

    public void removeStock(Stock stock) {
        stocks.remove(stock);
    }

    public void tradeStock(Stock stock, double bid) {
        stock.setBid(bid);
    }

    public void showAllStocks() {
        for (Stock stock : stocks) {
//            System.out.println(stock);
        	System.out.println(stock + " | Performance Metric: " + stock.getMetric());
        }
    }

    public static void demo() {
    	System.out.print("** Assigment 1 **");
    	
        StockMarket market = StockMarket.getInstance();

        // Create Stock Objects
        Stock netflix = new TechStock("NFLX", 855.20, "Netflix");
        Stock jnj = new PharmaStock("JNJ", 145.19, "Johnson & Johnson");

        // Add Stocks to Market
        market.addStock(netflix);
        market.addStock(jnj);
        

        // Perform Trades
        double[] bids = {10, 15, 20, -5, -10, 25};
        for (double bid : bids) {
        	System.out.println("\nProcessing bid: " + bid);
        	
            market.tradeStock(netflix, bid);
            market.tradeStock(jnj, bid);
            
            // Print Stock Metrics after Each Trade
            System.out.println(netflix.name + " | Price: " + netflix.price + " | Metric: " + netflix.getMetric());
            System.out.println(jnj.name + " | Price: " + jnj.price + " | Metric: " + jnj.getMetric());
            System.out.println("--------------------------------");
        }

        // Show Final Stock Details
        market.showAllStocks();
    }

}
