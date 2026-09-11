class Solution {
    public void generateSubSet (int [] nums,List<Integer> ds,List<List<Integer>> ans,int index){
        if (index==nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }

        
        ds.add(nums[index]);
        generateSubSet (nums,ds,ans,index+1);
        ds.remove(ds.size()-1);
        generateSubSet (nums,ds,ans,index+1);
        
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> ds = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        generateSubSet (nums,ds,ans,0);

        return ans;
    }
}
