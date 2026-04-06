class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length-1;
        int maxArea = 0;
        while (left<=right){
            int area = (right-left)*Math.min(heights[left],heights[right]);
            if (heights[left]>heights[right]){
                right--;
            }
            else{
                left++;
            }
            maxArea = Math.max(maxArea,area);
        }
        return maxArea;
    }

    
}
