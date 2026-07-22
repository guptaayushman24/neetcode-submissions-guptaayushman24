class Solution {
    public void generateSubSet (int [] nums,int index,List<List<Integer>> ans,List<Integer> ds){
        if (index==nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }

        ds.add(nums[index]);
        generateSubSet (nums,index+1,ans,ds);
        ds.remove(ds.size()-1);
        generateSubSet (nums,index+1,ans,ds);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();

        generateSubSet (nums,0,ans,ds);

        return ans;
    }
}
