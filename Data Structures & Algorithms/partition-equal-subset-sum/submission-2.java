class Solution {
    public boolean ifParition (int [] nums,int target,int index,Boolean [][] dp){
        if (index>=nums.length || target<0){
            return false;
        }
        if (target==0){
            return true;
        }
        if (dp[target][index]!=null){
            return dp[target][index];
        }
        Boolean take=false;
        if (nums[index]<=target){
            take = ifParition(nums,target-nums[index],index+1,dp);
        }

        Boolean nottake = ifParition (nums,target,index+1,dp);
        dp[target][index] = take || nottake;

        return take || nottake;
        
    }
    public boolean canPartition(int[] nums) {
        // s1+s2 = s
        // s1 = s2
        // s2+s2 = s
        // 2s2 = s
        // s2 = s/2
        // (s is the total sum)
        // If the total sum is divisible by 2 then call the function and find that we can find the sum/2 or not
        // If not then return false

        int sum = 0;
        for (int i=0;i<nums.length;i++){
            sum = sum+nums[i];
        }

        if (sum%2!=0){
            return false;
        }
        int target = sum/2;
        Boolean [][] dp = new Boolean [target+1][nums.length+1];
        return ifParition (nums,target,0,dp);
    }
}
