class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        while (low<=high){
            int mid = (low+high)/2;
            if (nums[mid]==target){
                return mid;
            }
            // Check whih portion is sorted
            if (nums[low]<=nums[mid]){ // Left portion is sorted
                if (nums[low]<=target && nums[mid]>=target){ // Target lies in the left portion
                    high = mid-1;
                }
                else{
                    low = mid+1;
                }
            }
            else{ // Right portion is sorted
                if (nums[mid]<=target && nums[high]>=target){ // Target lies in the right side
                    low = mid+1;
                }
                else{
                    high = mid-1;
                }
            }
        }

        return -1;
    }
}
