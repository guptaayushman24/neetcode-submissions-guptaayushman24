class Solution {
    public static int findWays(int[] nums, int target, int index, int sum, int[][] dp, int total) {
        if (index == nums.length) {
            return sum == target ? 1 : 0;
        }
        if (dp[index][sum + total] != Integer.MIN_VALUE) {
            return dp[index][sum + total];
        }

        int x = findWays(nums, target, index + 1, sum - nums[index], dp, total);
        int y = findWays(nums, target, index + 1, sum + nums[index], dp, total);

        dp[index][sum + total] = x + y;
        return x + y;
    }

    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;
        for (int i = 0; i < nums.length; i++) total += nums[i];

        if (Math.abs(target) > total)
            return 0; // ✓ after total is computed

        int[][] dp = new int[nums.length][2 * total + 1];
        for (int[] row : dp) Arrays.fill(row, Integer.MIN_VALUE);

        return findWays(nums, target, 0, 0, dp, total); // ✓ pass total
    }
}