class Solution {
    public static void findAllPermutations (int [] nums,List<Integer> ds,List<List<Integer>> res){
        // Base Case 
        if (nums.length==ds.size()){
            res.add(new ArrayList<>(ds));
            return;
        }

        // Iterate on the nums 
        for (int i=0;i<nums.length;i++){
            // Pick each element
            if (ds.contains(nums[i])){
                continue;
            }

            ds.add(nums[i]);
            // Go back (BackTrack)
            findAllPermutations (nums,ds,res);

            // Return remove from ds
            ds.remove(ds.size()-1);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> ds = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        findAllPermutations (nums,ds,res);

        return res;
    }
}
