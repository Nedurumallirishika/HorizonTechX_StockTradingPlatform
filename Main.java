import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        TradingPlatform platform = new TradingPlatform();

        while (true) {

            System.out.println("\n===== Stock Trading Platform =====");
            System.out.println("1. View Stocks");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. Wallet Balance");
            System.out.println("6. Exit");

            System.out.print("Enter Choice : ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    platform.displayStocks();
                    break;

                case 2:

                    platform.displayStocks();

                    System.out.print("\nEnter Stock Number : ");
                    int stockNo = sc.nextInt();

                    System.out.print("Enter Quantity : ");
                    int buyQty = sc.nextInt();

                    platform.buyStock(stockNo - 1, buyQty);

                    break;

                case 3:

                    platform.viewPortfolio();

                    System.out.print("\nEnter Stock Number : ");
                    stockNo = sc.nextInt();

                    System.out.print("Enter Quantity : ");
                    int sellQty = sc.nextInt();

                    platform.sellStock(stockNo - 1, sellQty);

                    break;

                case 4:

                    platform.viewPortfolio();

                    break;

                case 5:

                    platform.walletBalance();

                    break;

                case 6:

                    System.out.println("Thank You!");
                    sc.close();
                    return;

                default:

                    System.out.println("Invalid Choice.");
            }
        }
    }
}