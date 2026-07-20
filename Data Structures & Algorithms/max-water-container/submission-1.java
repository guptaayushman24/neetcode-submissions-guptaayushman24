class Solution {
    public int maxArea(int[] heights) {
        int maxArea = 0;
        int left = 0;
        int right = heights.length-1;
        int area = 0;
        while (left<=right){
            int maximumArea = Math.min(heights[left],heights[right])*(right-left);
            if (heights[left]>=heights[right]){
                right--;
            }
            else if (heights[left]<=heights[right]){
                left++;
            }
            area = Math.max(area,maximumArea);
        }

        return area;
    }
}
