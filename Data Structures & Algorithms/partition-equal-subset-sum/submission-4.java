class Solution {
    public static boolean checkIfTargetExist (int [] nums,int index,int sum,int target,Boolean [][] dp){
        if (index>=nums.length){
            return false;
        }

        if (sum==target){
            return true;
        }

        if (dp[index][sum]!=null){
            return dp[index][sum];
        }
        // Take the index
        boolean take = checkIfTargetExist (nums,index+1,sum+nums[index],target,dp);
        boolean notTake = checkIfTargetExist (nums,index+1,sum,target,dp);

        dp[index][sum] = take || notTake;
        return take || notTake;
    }
    public static int findTotalSum (int [] nums){
        int sum = 0;
        for (int i=0;i<nums.length;i++){
            sum = sum+nums[i];
        }

        return sum;
    }
    public boolean canPartition(int[] nums) {
        int target = findTotalSum (nums);
        Boolean [][] dp = new Boolean [nums.length+1][target+1];
        if (target%2!=0){
            return false;
        }
        return checkIfTargetExist (nums,0,0,target/2,dp);
    }
}
