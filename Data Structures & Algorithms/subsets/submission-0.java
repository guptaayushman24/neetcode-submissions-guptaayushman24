class Solution {
    public static void generateSubSet (int [] nums,int index,List<Integer> temp,List<List<Integer>> ans){
        if (index>=nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[index]);
        generateSubSet (nums,index+1,temp,ans);
        temp.remove(temp.size()-1);
        generateSubSet (nums,index+1,temp,ans);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        generateSubSet (nums,0,temp,ans);

        return ans;
    }
}
