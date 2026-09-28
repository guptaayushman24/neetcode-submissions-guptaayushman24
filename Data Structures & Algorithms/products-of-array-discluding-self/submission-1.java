class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prefixMultiply = 1;
        int suffixMultiply = 1;
        int[] ans = new int[nums.length];
        int[] prefix = new int[nums.length];
        int[] sufix = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            prefix[i] = prefixMultiply * nums[i];
            prefixMultiply = prefixMultiply * nums[i];
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            sufix[i] = suffixMultiply * nums[i];
            suffixMultiply = suffixMultiply * nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                ans[i] = 1 * sufix[i + 1];
            }

            else if (i == nums.length - 1) {
                ans[i] = prefix[i - 1] * 1;
            }

            else {
                ans[i] = prefix[i - 1] * sufix[i + 1];
            }
        }
        return ans;
    }
}
