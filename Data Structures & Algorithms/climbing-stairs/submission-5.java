class Solution {
    public static int noOfWaysToClimb (int n,int [] dp){
         if (n<0){
            return 0;
        }

        if (n==0){
            return 1;
        }
        if (dp[n]!=-1){
            return dp[n];
        }
        int x = noOfWaysToClimb (n-1,dp);
        int y = noOfWaysToClimb (n-2,dp);

        dp[n] = x+y;
        return x+y;
    }
    public int climbStairs(int n) {
        int [] dp = new int [n+1];
        Arrays.fill(dp,-1);
        int ans = noOfWaysToClimb (n,dp);

        return ans;
    }
}
