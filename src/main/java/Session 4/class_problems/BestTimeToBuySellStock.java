public class BestTimeToBuySellStock {

    public static int maxProfit(int[] prices) {

        int minimumPrice = prices[0];

        int maximumProfit = 0;

        for (int i = 1; i < prices.length; i++) {

            int profit =
                prices[i] - minimumPrice;


            if (profit > maximumProfit) {

                maximumProfit = profit;
            }


            if (prices[i] < minimumPrice) {

                minimumPrice = prices[i];
            }
        }

        return maximumProfit;
    }


    public static void main(String[] args) {

        int[] prices = {
            7, 1, 5, 3, 6, 4
        };

        int profit = maxProfit(prices);

        System.out.println(
            "Maximum Profit: " + profit
        );
    }
}