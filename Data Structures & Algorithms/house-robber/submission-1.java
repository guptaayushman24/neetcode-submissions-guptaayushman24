class Solution {
    public static int robTheHouse (int [] nums,int index,int [] dp){
        if (index>=nums.length){
            return 0;
        }
        if (dp[index]!=-1){
            return dp[index];
        }
        int x = nums[index]+robTheHouse (nums,index+2,dp);
        int y = robTheHouse (nums,index+1,dp);

        dp[index] = Math.max(x,y);
        return Math.max(x,y);
    }
    public int rob(int[] nums) {
        int [] dp = new int [nums.length+1];
        Arrays.fill(dp,-1);
        int ans = robTheHouse (nums,0,dp);

        return ans;
    }
}
