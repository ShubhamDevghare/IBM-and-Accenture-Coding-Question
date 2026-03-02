package AccentureCoddingQue.Aug_13_2024;
/*
//this type of Ques not Asked
// Very Easy...........
You are working on a financial analysing tool which represents daily stock prices of a company over time.
Each element in an integer array A of size N represents the closing price of the stock for that particular
 day. Your task is to find and return an integer value representing the total number of days where
 the stock market price decreased indicating negative growth.
 */
public class StockAnalyzer {
    public static int countDecreasedDays(int[] prices) {
        int decreasedDays = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[i - 1]) {
                decreasedDays++;
            }
        }

        return decreasedDays;
    }

    public static void main(String[] args) {
        int[] stockPrices = {100, 98, 105, 102, 99, 95, 97};
        int result = countDecreasedDays(stockPrices);
        System.out.println("Total number of days with negative growth: " + result);
    }
}
