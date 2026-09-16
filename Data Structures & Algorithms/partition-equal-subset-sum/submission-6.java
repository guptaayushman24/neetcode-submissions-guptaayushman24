class Solution {
    public boolean checkIfSubSetSumExist(int[] nums, int target, int index,Boolean [][] dp) {
        /*if (index == nums.length && target == 0) {
            return true;
        }*/

        if (index >= nums.length) {
            return false;
        }

        if (target < 0) {
            return false;
        }

        if (target == 0) {
            return true;
        }
        if (dp[index][target]!=null){
            return dp[index][target];
        }

        boolean left = false;
        if (nums[index] <= target) {
            left = checkIfSubSetSumExist(nums, target - nums[index], index + 1,dp);
        }
        boolean right = checkIfSubSetSumExist(nums, target, index + 1,dp);

        dp[index][target] = left || right;
        return left || right;
    }
    public boolean canPartition(int[] nums) {
        // s1 = s2
        // s1+s2 = 0
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
        }

        int target = sum / 2;
        if (sum % 2 != 0) {
            return false;
        }
        Boolean [][] dp = new Boolean [nums.length+1][target+1];
         
        boolean ans = checkIfSubSetSumExist(nums, target, 0,dp);
        return ans;
    }
}
