class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i=0;i<prices.length;i++){
            int buy = prices[i];
            for (int j=i+1;j<prices.length;j++){
                maxProfit = Math.max(maxProfit,prices[j]-buy);
            }
        }

        return maxProfit;
    }

}
