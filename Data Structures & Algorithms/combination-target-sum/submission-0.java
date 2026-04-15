class Solution {
    int sum = 0;
    public  void findCombinationSum (int [] nums,List<List<Integer>> ans,List<Integer> temp,int index,int target){
        if (index>=nums.length){
            return;
        }

        if (sum==target){
            ans.add(new ArrayList<>(temp));
            return;
        }
        
        if (sum>target){
            return;
        }

        sum = sum+nums[index];
        temp.add(nums[index]);
        findCombinationSum (nums,ans,temp,index,target);
        sum = sum-temp.get(temp.size()-1);
        temp.remove(temp.size()-1);
        findCombinationSum (nums,ans,temp,index+1,target);
        
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        findCombinationSum (nums,ans,temp,0,target);

        return ans;
    }
}
