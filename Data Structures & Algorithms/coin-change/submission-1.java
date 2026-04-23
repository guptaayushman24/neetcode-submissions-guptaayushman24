class Solution {
    public static int findNoOfWays(int[] coins, int amount, int index, int ways,int [][] dp) {
        // Impossible Path
        if (index >= coins.length) {
            return (int) Math.pow(10,9);
        }
        if (amount==0){
            return 0;
        }
        if (dp[amount][index]!=-1){
            return dp[amount][index];
        }
        int x = (int) Math.pow(10, 9);
        if (amount >= coins[index]) {
            x = 1+findNoOfWays(coins, amount - coins[index], index, ways,dp);
        }

        int y = findNoOfWays(coins, amount, index + 1, ways,dp);
        dp[amount][index] = Math.min(x,y);
        return Math.min(x,y);
    }
    public int coinChange(int[] coins, int amount) {
        int [][] dp = new int [amount+1][coins.length+1];
        for (int i=0;i<dp.length;i++){
            for (int j=0;j<dp[0].length;j++){
                dp[i][j] = -1;
            }
        }
        if (amount==0){
            return 0;
        }
        int ans = findNoOfWays(coins, amount, 0, 0,dp);

        if (ans >= (int) Math.pow(10,9)) {
            return -1;
        }

        return ans;
    }
}
