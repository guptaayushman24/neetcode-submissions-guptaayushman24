class Solution {
    public static int houseRobber (int [] nums,int index,int [] dp){
        if (index>=nums.length){
            return 0;
        }
        if (dp[index]!=-1){
            return dp[index];
        }
        int x = nums[index]+houseRobber (nums,index+2,dp);
        int y = 0+houseRobber (nums,index+1,dp);
        
        dp[index] = Math.max(x,y);
        return Math.max(x,y);
    }
    public int rob(int[] nums) {
        int maximumAmount = 0;
        int [] dp = new int [nums.length+1];
        Arrays.fill(dp,-1);
        maximumAmount = houseRobber (nums,0,dp);

        return maximumAmount;
    }
}
