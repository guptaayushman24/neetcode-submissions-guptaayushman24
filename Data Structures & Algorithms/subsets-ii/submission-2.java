class Solution {
    public void generateSubSetWithoutDuplicate (List<List<Integer>> ans,List<Integer> ds,int start,int [] nums){
        ans.add(new ArrayList<>(ds));

        for (int i=start;i<nums.length;i++){
            if (i>start && nums[i]==nums[i-1]){
                continue;
            }

            ds.add(nums[i]);
            generateSubSetWithoutDuplicate (ans,ds,i+1,nums);
            ds.remove(ds.size()-1);
        }


    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();

        Arrays.sort(nums);

        generateSubSetWithoutDuplicate (ans,ds,0,nums);

        return ans;
    }
}
