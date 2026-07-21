class Solution {
    public void findAllPermutation (int [] nums,List<Integer> ds,List<List<Integer>> ans,boolean [] visited){
        if (ds.size()==nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i=0;i<nums.length;i++){
            if (visited[i]==false){
                ds.add(nums[i]);
                visited[i] = true;
                findAllPermutation (nums,ds,ans,visited);
                 ds.remove(ds.size()-1);
                 visited[i] = false;
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> ds = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        boolean [] visited = new boolean [nums.length];

        findAllPermutation (nums,ds,ans,visited);

        return ans;
    }
}
