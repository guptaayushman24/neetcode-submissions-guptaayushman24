class Solution {
    public static int findCombination(int amount, int[] coins, int index, int[][] dp) {
        if (amount == 0) {
            return 1;
        }
        if (amount < 0 || index >= coins.length) {
            return 0;
        }

        if (dp[amount][index] != -1) {
            return dp[amount][index];
        }

        int x = 0;
        if (amount >= coins[index]) {
            x = findCombination(amount - coins[index], coins, index, dp);
        }

        int y = findCombination(amount, coins, index + 1, dp);

        dp[amount][index] = x + y;
        return x + y;
    }
    public int change(int amount, int[] coins) {
        int[][] dp = new int[amount + 1][coins.length + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        int noOfCombination = findCombination(amount, coins, 0, dp);
        return noOfCombination;
    }
}
