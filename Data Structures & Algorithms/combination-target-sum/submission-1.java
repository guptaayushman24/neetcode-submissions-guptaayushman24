class Solution {
    public static void findCombinationSum (int [] nums,int target,List<List<Integer>> ans,List<Integer> ds,int index){
        if (target==0){
            ans.add(new ArrayList<>(ds));
            return;
        }

        if (target<0 || index>=nums.length){
            return;
        }
        
        
        if (target>=nums[index]){
            ds.add(nums[index]);
            findCombinationSum (nums,target-nums[index],ans,ds,index);
            ds.remove(ds.size()-1);
        }

        findCombinationSum (nums,target,ans,ds,index+1);
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();

        findCombinationSum (nums,target,ans,ds,0);

        return ans;
    }
}
