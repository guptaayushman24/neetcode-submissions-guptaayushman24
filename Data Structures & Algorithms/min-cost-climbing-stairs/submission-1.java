class Solution {
    public static int functionToFindCost (int [] cost,int index,int [] dp){
        if (index>=cost.length){
            return 0;
        }
        if (dp[index]!=-1){
            return dp[index];
        }
        int x = cost[index]+functionToFindCost (cost,index+1,dp);
        int y = cost[index]+functionToFindCost (cost,index+2,dp);

        dp[index] = Math.min(x,y);
        return Math.min(x,y);
    }
    public int minCostClimbingStairs(int[] cost) {
        int [] dp = new int [cost.length+1];
        Arrays.fill(dp,-1);
        int startFrom0thStep = functionToFindCost (cost,0,dp);
        int startFrom1stStep = functionToFindCost (cost,1,dp);

        return Math.min(startFrom0thStep,startFrom1stStep);
    }
}
