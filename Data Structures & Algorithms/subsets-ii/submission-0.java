class Solution {
    public static void findAllSubSetWithDup(int[] nums, List<Integer> temp, List<List<Integer>> ans, int index) {
        if (index >= nums.length) {
            ans.add(new ArrayList<>(temp));  // ✅ save subset at leaf
            return;
        }

        // include nums[index]
        temp.add(nums[index]);
        findAllSubSetWithDup(nums, temp, ans, index + 1);  // ✅ correct order
        temp.remove(temp.size() - 1);

        // skip duplicates before the no-pick branch
        while (index + 1 < nums.length && nums[index] == nums[index + 1]) {
            index++;  // ✅ skip same value at same level
        }

        // exclude nums[index]
        findAllSubSetWithDup(nums, temp, ans, index + 1);  // ✅ correct order
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);  // ✅ must sort to group duplicates
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        findAllSubSetWithDup(nums, temp, ans, 0);
        return ans;
    }
}