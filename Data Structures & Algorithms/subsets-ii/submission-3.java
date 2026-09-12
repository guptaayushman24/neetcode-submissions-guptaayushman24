class Solution {
    public void generateSubSet(int[] nums, List<List<Integer>> ans, List<Integer> ds, int index) {
        Collections.sort(ds);
        if (ans.contains(ds)) {
            return;
        }

        if (index == nums.length) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        ds.add(nums[index]);
        generateSubSet(nums, ans, ds, index + 1);
        ds.remove(ds.size() - 1);
        while (index<nums.length-1 && nums[index]==nums[index+1]){
            index++;
        }
        generateSubSet(nums, ans, ds, index + 1);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();

        generateSubSet(nums, ans, ds, 0);

        return ans;
    }
}
