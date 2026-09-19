class Solution {
    public static int findMaxProfit(int[] prices, int index, int buy, int[][] dp) {
        if (index >= prices.length) {
            return 0;
        }

        if (dp[index][buy] != -1) {
            return dp[index][buy];
        }

        if (buy == 1) {
            int sellingStock = -prices[index] + findMaxProfit(prices, index + 1, 0, dp);
            int notSellingStock = 0 + findMaxProfit(prices, index + 1, 1, dp);
            dp[index][buy] = Math.max(sellingStock, notSellingStock);
            return Math.max(sellingStock, notSellingStock);
        }

        else {
            int buyStock = prices[index] + findMaxProfit(prices, index + 2, 1, dp);
            int notBuyingStock = 0 + findMaxProfit(prices, index + 1, 0, dp);

            dp[index][buy] = Math.max(buyStock, notBuyingStock);
            return Math.max(buyStock, notBuyingStock);
        }
    }
    public int maxProfit(int[] prices) {
        // coolDown period
        int [][] dp = new int [prices.length][2];
        for (int i=0;i<dp.length;i++){
            for (int j=0;j<dp[0].length;j++){
                dp[i][j] = -1;
            }
        }
       

        int ans = findMaxProfit(prices, 0, 1, dp);

        return ans;
    }
}
