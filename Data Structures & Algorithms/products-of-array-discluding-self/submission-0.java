class Solution {
    public static int checkforzeros (int [] nums){
        int count = 0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]==0){
                count++;
            }
        }
        return count;
    }
        public static int zeroposition (int [] nums){
            int idx = 0;
             for (int i=0;i<nums.length;i++){
                if (nums[i]==0){
                    idx = i;
                }
            
            }
            return idx;
        }
    
    public int[] productExceptSelf(int[] nums) {
        int [] ans = new int [nums.length];
        Arrays.fill(ans,0);
        int check = checkforzeros (nums);
        if (check>1){
            return ans;
        
        }
        else if (check==1){
            int position = zeroposition (nums);
            int multiply = 1;
            for (int i=0;i<nums.length;i++){
                if (i==position){
                    continue;
                }
                else{
                    multiply = multiply*nums[i];
                }
            }
            for (int i=0;i<nums.length;i++){
                if (i!=position){
                    nums[i] = 0;
                }
                else{
                    nums[i] = multiply;
                }
            }
            return nums;
        }
        else{
            int multiply = 1;
            for (int i=0;i<nums.length;i++){
                multiply = multiply*nums[i];
            }
            for (int i=0;i<nums.length;i++){
                nums[i] = multiply/nums[i];
            }
        }
        return nums;
    }
}
