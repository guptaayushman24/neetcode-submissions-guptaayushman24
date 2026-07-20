class Solution {
    public int maxProduct(int[] nums) {
        int[] prefixProduct = new int[nums.length];
        int[] suffixProduct = new int[nums.length];

        int prefixMultiply = 1;
        int suffixMultiply = 1;

        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            prefixMultiply = prefixMultiply * nums[i];
            prefixProduct[i] = prefixMultiply;
            if (prefixMultiply == 0) {
               prefixMultiply = 1;
            }
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            suffixMultiply = suffixMultiply * nums[i];
            suffixProduct[i] = suffixMultiply;
            if (suffixMultiply == 0) {
                suffixMultiply = 1;
            } 
        }

        for (int i = 0; i < nums.length; i++) {
            int result = Math.max(prefixProduct[i], suffixProduct[i]);
            ans = Math.max(result, ans);
        }

        return ans;
    }
}
