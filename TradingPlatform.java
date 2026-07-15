import java.util.ArrayList;

public class TradingPlatform {

    ArrayList<Stock> market = new ArrayList<>();
    ArrayList<Stock> portfolio = new ArrayList<>();

    double wallet = 100000;

    // Constructor
    public TradingPlatform() {

        market.add(new Stock("TCS", 3500, 20));
        market.add(new Stock("Infosys", 1500, 30));
        market.add(new Stock("Wipro", 250, 40));
        market.add(new Stock("HCL", 1200, 15));
    }

    // Display Available Stocks
    public void displayStocks() {

        System.out.println("\n===== Available Stocks =====");

        for (int i = 0; i < market.size(); i++) {

            Stock s = market.get(i);

            System.out.println((i + 1) + ". " +
                    s.stockName +
                    " | Price : ₹" + s.price +
                    " | Quantity : " + s.quantity);
        }
    }

    // Buy Stock
    public void buyStock(int index, int qty) {

        if (index < 0 || index >= market.size()) {
            System.out.println("Invalid Stock.");
            return;
        }

        Stock s = market.get(index);

        if (qty > s.quantity) {
            System.out.println("Not enough stocks available.");
            return;
        }

        double total = qty * s.price;

        if (wallet < total) {
            System.out.println("Insufficient Wallet Balance.");
            return;
        }

        wallet -= total;
        s.quantity -= qty;

        boolean found = false;

        for (int i = 0; i < portfolio.size(); i++) {

            Stock p = portfolio.get(i);

            if (p.stockName.equalsIgnoreCase(s.stockName)) {

                p.quantity += qty;
                found = true;
                break;
            }
        }

        if (!found) {
            portfolio.add(new Stock(s.stockName, s.price, qty));
        }

        System.out.println("Stock Purchased Successfully.");
    }

    // Sell Stock
    public void sellStock(int index, int qty) {

        if (index < 0 || index >= portfolio.size()) {
            System.out.println("Invalid Choice.");
            return;
        }

        Stock s = portfolio.get(index);

        if (qty > s.quantity) {
            System.out.println("You don't have enough shares.");
            return;
        }

        wallet += qty * s.price;

        s.quantity -= qty;

        // Return stocks back to market
        for (int i = 0; i < market.size(); i++) {

            if (market.get(i).stockName.equalsIgnoreCase(s.stockName)) {
                market.get(i).quantity += qty;
                break;
            }
        }

        if (s.quantity == 0) {
            portfolio.remove(index);
        }

        System.out.println("Stock Sold Successfully.");
    }

    // View Portfolio
    public void viewPortfolio() {

        if (portfolio.isEmpty()) {
            System.out.println("Portfolio is Empty.");
            return;
        }

        System.out.println("\n===== Your Portfolio =====");

        for (int i = 0; i < portfolio.size(); i++) {

            Stock s = portfolio.get(i);

            System.out.println((i + 1) + ". " +
                    s.stockName +
                    " | Quantity : " + s.quantity +
                    " | Price : ₹" + s.price);
        }
    }

    // Wallet Balance
    public void walletBalance() {

        System.out.println("\nWallet Balance : ₹" + wallet);
    }
}