class Solution {
    public static int findNoOfWays (int n,int [] dp){
        if (n==0 || n==1){
            return 1;
        }

        if (dp[n]!=-1){
            return dp[n];
        }
        int x = findNoOfWays(n-1,dp);
        int y = findNoOfWays(n-2,dp);

        dp[n] = x+y;
        return x+y;
    }
    public int climbStairs(int n) {
        int [] dp = new int [n+1];
        Arrays.fill(dp,-1);
        int ans = findNoOfWays (n,dp);
        return ans;
    }
}
