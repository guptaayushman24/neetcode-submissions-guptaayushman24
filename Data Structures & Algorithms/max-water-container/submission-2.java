class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length - 1;
        int left = 0;
        int right = n;
        int maxArea = Integer.MIN_VALUE;
        while (left < right) {
            int area = Math.min(heights[left], heights[right]) * (right - left);
            maxArea = Math.max(maxArea, area);

            if (heights[left] <= heights[right]) {
                left++;
            }

            else if (heights[left] > heights[right]) {
                right--;
            }
        }

        return maxArea;
    }
}
